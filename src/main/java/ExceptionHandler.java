import java.util.LinkedList;
import java.util.Queue;

public class ExceptionHandler {
    private static ExceptionHandler ourInstance = new ExceptionHandler();

    private static Queue<ICommand> queue = new LinkedList<>();

    public static ExceptionHandler getInstance() {
        return ourInstance;
    }

    public static Queue<ICommand>  getQueue() {
        return queue;
    }


    private ExceptionHandler() {
    }

    public void handle(ICommand command, Exception e) {
        if (command instanceof Move && e instanceof RuntimeException) {
            System.out.println("adding to the queue: SecondTryMoveCommand");
            queue.add(new SecondTryMoveCommand(command));
        }

        if (command instanceof SecondTryMoveCommand && e instanceof RuntimeException) {
            System.out.println("adding to the queue: ThirdTryMoveCommand");
            queue.add(new ThirdTryMoveCommand(command));
        }

        if (command instanceof ThirdTryMoveCommand && e instanceof RuntimeException) {
            System.out.println("adding to the queue: new Log");
            queue.add(new Log(command, e));
        }

    }
}


