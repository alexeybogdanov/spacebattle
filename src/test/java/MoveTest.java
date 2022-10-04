import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.doThrow;

class MoveTest {

    Move move;

    @Mock
    Movable movable;

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
}