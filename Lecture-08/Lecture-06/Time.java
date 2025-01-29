public class Time {
    // Constants for standard time values
    public static final int HOURS_PER_DAY = 24;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int SECONDS_PER_MINUTE = 60;

    // Private instance variables for hours, minutes, and seconds
    private int hours;
    private int minutes;
    private int seconds;

    // Default constructor (sets time to 00:00:00)
    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    // Parameterized constructor to initialize a Time object
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;       // Initialize hours
        this.minutes = minutes;   // Initialize minutes
        this.seconds = seconds;   // Initialize seconds
        normalize();              // Ensure valid values
    }

    // Getter for hours
    public int getHours() {
        return hours;
    }

    // Getter for minutes
    public int getMinutes() {
        return minutes;
    }

    // Getter for seconds
    public int getSeconds() {
        return seconds;
    }

    // Setter for hours (no exceptions, sets to 0 if invalid)
    public void setHours(int hours) {
        if (hours >= 0 && hours < HOURS_PER_DAY) {
            this.hours = hours;
        } else {
            System.out.println("Invalid hours! Must be between 0 and 23.");
            this.hours = 0; // Reset to default
        }
    }

    // Setter for minutes (no exceptions, sets to 0 if invalid)
    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes < MINUTES_PER_HOUR) {
            this.minutes = minutes;
        } else {
            System.out.println("Invalid minutes! Must be between 0 and 59.");
            this.minutes = 0; // Reset to default
        }
    }

    // Setter for seconds (no exceptions, sets to 0 if invalid)
    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds < SECONDS_PER_MINUTE) {
            this.seconds = seconds;
        } else {
            System.out.println("Invalid seconds! Must be between 0 and 59.");
            this.seconds = 0; // Reset to default
        }
    }

    // Method to compare two Time objects for equality
    public boolean equals(Time other) {
        return (this.hours == other.hours) &&
               (this.minutes == other.minutes) &&
               (this.seconds == other.seconds);
    }

    // Method to increment the time by one second
    public void increase() {
        seconds++; // Increment seconds
        normalize(); // Normalize the time in case of overflow
    }

    // Private method to normalize time values
    private void normalize() {
        // Normalize seconds into minutes
        int carry = seconds / SECONDS_PER_MINUTE;
        seconds %= SECONDS_PER_MINUTE;

        // Normalize minutes into hours
        minutes += carry;
        carry = minutes / MINUTES_PER_HOUR;
        minutes %= MINUTES_PER_HOUR;

        // Normalize hours within a 24-hour day
        hours = (hours + carry) % HOURS_PER_DAY;
    }

    // Method to return time as a simple string
    public String toString() {
        return hours + "h " + minutes + "m " + seconds + "s";
    }

    // Main method to demonstrate the functionality of the Time class
    public static void main(String[] args) {
        // Create a Time object using the default constructor
        Time time1 = new Time();
        System.out.println("Default Time: " + time1.toString()); // Output: 0h 0m 0s

        // Create a Time object with specific values
        Time time2 = new Time(23, 59, 59);
        System.out.println("Initialized Time: " + time2.toString()); // Output: 23h 59m 59s

        // Increase time by one second
        time2.increase();
        System.out.println("After 1 Second: " + time2.toString()); // Output: 0h 0m 0s

        // Update time using setters
        time2.setHours(12);
        time2.setMinutes(30);
        time2.setSeconds(45);
        System.out.println("Updated Time: " + time2.toString()); // Output: 12h 30m 45s

        // Create another Time object for comparison
        Time time3 = new Time(12, 30, 45);
        System.out.println("Times are equal: " + time2.equals(time3)); // Output: true

        // Attempt to set invalid values
        time3.setHours(25); // Invalid hours, resets to 0
        System.out.println("After invalid hours: " + time3.toString()); // Output: 0h 30m 45s
    }
}
