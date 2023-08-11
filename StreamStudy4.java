import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamStudy4 {

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList());

        Runnable squareTask = () -> {
            List<Integer> squares = numbers.stream()
            .map(number -> number * number)
            .collect(Collectors.toList());

            System.out.println("Squared numbers : " + squares);
        };

        Thread thread = new Thread(squareTask);
        thread.start();

        // Main thread continues its work
        System.out.println("Main thread continues its work...");

        try {
            thread.join(); // wait for the thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
    
}
