import java.text.SimpleDateFormat;
import java.util.Date;

// Clock class responsible for displaying the current time and date
public class Clock {
    // specifying the format of display
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

    // Method to continuously update and print the current time
    public void displayTime() {
        while (true) {
            // Get the current time and date
            String currentTime = dateFormatter.format(new Date());
            System.out.println(currentTime);

            // Sleep for one second to simulate a ticking clock
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Clock display thread interrupted.");
            }
        }
    }

    // Background thread to keep updating time (no actual function here but can be extended for logic)
    public void updateTime() {
        while (true) {
            // For now, we only simulate the background running without actions
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Clock updating thread interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock();

        // Thread to display the clock in the console
        Thread displayThread = new Thread(() -> clock.displayTime());
        displayThread.setPriority(Thread.MAX_PRIORITY); // Setting higher priority

        // Background thread for time updating (lower priority)
        Thread updateThread = new Thread(() -> clock.updateTime());
        updateThread.setPriority(Thread.MIN_PRIORITY); // Setting lower priority

        // Start both threads
        displayThread.start();
        updateThread.start();
    }
}
