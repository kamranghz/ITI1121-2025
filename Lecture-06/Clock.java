public class Clock {
    // Attributes to represent hours, minutes, and seconds
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor to initialize a Clock object
    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;  // Set the value of hours
        this.minutes = minutes;  // Set the value of minutes
        this.seconds = seconds;  // Set the value of seconds
        adjustTime();  // Ensure the time is valid
    }

    // Getter method to get the value of hours
    public int getHours() {
        return hours;
    }

    // Getter method to get the value of minutes
    public int getMinutes() {
        return minutes;
    }

    // Getter method to get the value of seconds
    public int getSeconds() {
        return seconds;
    }

    // Method to add seconds to the current time
    public void addSeconds(int extraSeconds) {
        this.seconds += extraSeconds; // Add extra seconds
        adjustTime();  // Adjust the time to be valid
    }

    // Method to normalize time (convert overflow seconds/minutes into valid time)
    private void adjustTime() {
        // Convert extra seconds into minutes
        if (seconds >= 60) {
            minutes += seconds / 60;  // Add extra minutes
            seconds = seconds % 60;  // Keep remaining seconds
        }
        // Convert extra minutes into hours
        if (minutes >= 60) {
            hours += minutes / 60;  // Add extra hours
            minutes = minutes % 60;  // Keep remaining minutes
        }
        // Ensure hours are within a 24-hour range
        if (hours >= 24) {
            hours = hours % 24;  // Reset hours to fit within 24 hours
        }
    }

    // Method to display the current time in HH:MM:SS format
    public String displayTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    // Main method to demonstrate the Clock class
    public static void main(String[] args) {
        // Create a new Clock object
        Clock myClock = new Clock(23, 59, 50);

        // Display the initial time
        System.out.println("Initial Time: " + myClock.displayTime());

        // Add 15 seconds
        myClock.addSeconds(15);
        System.out.println("After Adding 15 Seconds: " + myClock.displayTime());

        // Add 120 seconds (2 minutes)
        myClock.addSeconds(120);
        System.out.println("After Adding 120 Seconds: " + myClock.displayTime());
    }
}
