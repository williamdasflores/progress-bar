import java.util.stream.Stream;

public class ProgressBar {

    public static void main(String[] args) throws InterruptedException {
        ProgressBar progressBar = new ProgressBar();
        progressBar.printProgressBar("Loading", 60, 120);
    }

    public void printProgressBar(String message, int length, long timeInterval) throws InterruptedException {
        char incomplete = '░';
        char complete = '█';
        StringBuilder builder = new StringBuilder();

        Stream.generate(() -> incomplete).limit(length).forEach(builder::append);

        // the code above replace the for below
        /*for (int i = 0; i < length; i++) {
            builder.append(incomplete);
        }*/
        System.out.println(message);

        for (int i = 0; i < length; i++) {
            builder.replace(i, i+1, String.valueOf(complete));
            String progressBar = "\r" + builder;
            System.out.print(progressBar);

            Thread.sleep(timeInterval);
        }
    }
}
