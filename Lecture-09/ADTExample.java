// Step 1: Define an Abstract Data Type using an Interface
interface Time {
    int getHours();
    int getMinutes();
    int getSeconds();
}

// Step 2: Implement the ADT in a Concrete Class
class DigitalClock implements Time {
    private int hours, minutes, seconds;

    // Constructor to initialize time
    public DigitalClock(int h, int m, int s) {
        this.hours = h;
        this.minutes = m;
        this.seconds = s;
    }

    // Implement the methods from the Time interface
    @Override
    public int getHours() { return hours; }
    @Override
    public int getMinutes() { return minutes; }
    @Override
    public int getSeconds() { return seconds; }

    // Display time in a formatted way
    public void displayTime() {
        System.out.printf("Current Time: %02d:%02d:%02d\n", hours, minutes, seconds);
    }
}

// Step 3: Test the ADT in the Main Class
public class ADTExample {
    public static void main(String[] args) {
        Time clock = new DigitalClock(10, 30, 45); // Create an instance
        System.out.println("Hours: " + clock.getHours());
        System.out.println("Minutes: " + clock.getMinutes());
        System.out.println("Seconds: " + clock.getSeconds());

        // Using the displayTime() method (only available in DigitalClock)
        if (clock instanceof DigitalClock) {
            ((DigitalClock) clock).displayTime();
        }
    }
}
