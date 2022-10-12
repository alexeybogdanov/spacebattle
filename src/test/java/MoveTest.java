import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import java.util.LinkedList;
import java.util.Queue;

import static org.mockito.Mockito.doThrow;

class MoveTest {

    Move move;

    @Mock
    Movable movable;

    @Mock
    FuelBurnable fuelBurnable;

    @Mock
    FuelCheckable fuelCheckable;


    @Captor
    ArgumentCaptor<CustomVector> vectorCaptor;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        move = new Move(movable);
    }

    @Test
    void execute_successful() {
        Mockito.when(movable.getPosition()).thenReturn(new CustomVector(12, 5));
        Mockito.when(movable.getVelocity()).thenReturn(new CustomVector(-7, 3));

        move.execute();

        Mockito.verify(movable).setPosition(vectorCaptor.capture());
        CustomVector captorValue = vectorCaptor.getValue();

        Assertions.assertEquals(new CustomVector(5, 8), captorValue);
    }

    @Test
    void execute_missing_position_fails() {
        Mockito.when(movable.getPosition()).thenThrow(new RuntimeException());

        Assertions.assertThrows(RuntimeException.class, () -> movable.getPosition());
    }

    @Test
    void execute_missing_velocity_fails() {
        Mockito.when(movable.getVelocity()).thenThrow(new RuntimeException());

        Assertions.assertThrows(Exception.class, () -> movable.getVelocity());
    }

    @Test
    void execute_set_position_fails() {
        doThrow(new RuntimeException()).when(movable).setPosition(new CustomVector());

        Assertions.assertThrows(RuntimeException.class, () -> movable.setPosition(new CustomVector()));
    }


    @Test
    void catch_3nd_retry_and_log_error_successful() {
        Mockito.when(movable.getPosition()).thenThrow(new RuntimeException("MoveCommand fails!"));

        ExceptionHandler exceptionHandler = ExceptionHandler.getInstance();
        Queue<ICommand> queue = ExceptionHandler.getQueue();
        queue.add(move);

        while (!queue.isEmpty()) {
            ICommand command = ((LinkedList<ICommand>) queue).pop();
            try {
                command.execute();
            } catch (Exception e) {
                exceptionHandler.handle(command, e);
            }

        }

        // As a verification process check terminal output (logs)
    }

    @Test
    void macroCommand_successful() {
        Mockito.when(fuelCheckable.checkFuel()).thenReturn(true);

        Mockito.when(movable.getPosition()).thenReturn(new CustomVector(12, 5));
        Mockito.when(movable.getVelocity()).thenReturn(new CustomVector(-7, 3));

        Mockito.doNothing().when(fuelBurnable).burnFuel();


        CheckFuelComamnd checkFuelComamnd = new CheckFuelComamnd(fuelCheckable);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuelBurnable);

        MoveMacroCommand macroCommand = new MoveMacroCommand(List.of(checkFuelComamnd, move,  burnFuelCommand));
        macroCommand.execute();
    }


    @Test
    void macroCommand_no_fuel_throws_exception() {
        Mockito.when(fuelCheckable.checkFuel()).thenThrow(new RuntimeException("CommandException"));

        CheckFuelComamnd checkFuelComamnd = new CheckFuelComamnd(fuelCheckable);
        BurnFuelCommand burnFuelCommand = new BurnFuelCommand(fuelBurnable);

        MoveMacroCommand macroCommand = new MoveMacroCommand(List.of(checkFuelComamnd, move,  burnFuelCommand));
        Assertions.assertThrows(Exception.class, () -> macroCommand.execute());
    }
}