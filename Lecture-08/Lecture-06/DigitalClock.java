class DigitalClock {
    // Private variables to store hours, minutes, and seconds
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor to initialize the clock
    public DigitalClock(int hours, int minutes, int seconds) {
        setHours(hours);   // Use setter to validate hours
        setMinutes(minutes); // Use setter to validate minutes
        setSeconds(seconds); // Use setter to validate seconds
    }

    // Getter for hours
    public int getHours() {
        return hours;
    }

    // Setter for hours with validation
    public void setHours(int hours) {
        if (hours >= 0 && hours < 24) { // Valid range: 0 to 23
            this.hours = hours;
        } else {
            System.out.println("Invalid hours! Setting to default (0).");
            this.hours = 0; // Default to 0 if invalid
        }
    }

    // Getter for minutes
    public int getMinutes() {
        return minutes;
    }

    // Setter for minutes with validation
    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes < 60) { // Valid range: 0 to 59
            this.minutes = minutes;
        } else {
            System.out.println("Invalid minutes! Setting to default (0).");
            this.minutes = 0; // Default to 0 if invalid
        }
    }

    // Getter for seconds
    public int getSeconds() {
        return seconds;
    }

    // Setter for seconds with validation
    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds < 60) { // Valid range: 0 to 59
            this.seconds = seconds;
        } else {
            System.out.println("Invalid seconds! Setting to default (0).");
            this.seconds = 0; // Default to 0 if invalid
        }
    }

    // Method to display the current time in HH:MM:SS format
    public void displayTime() {
        System.out.printf("Current Time: %02d:%02d:%02d\n", hours, minutes, seconds);
    }

    public static void main(String[] args) {
        // Create a DigitalClock object with valid time
        DigitalClock clock = new DigitalClock(12, 30, 45);
        clock.displayTime(); // Output: Current Time: 12:30:45

        // Update the time using setters
        clock.setHours(23);
        clock.setMinutes(59);
        clock.setSeconds(58);
        clock.displayTime(); // Output: Current Time: 23:59:58

        // Try setting invalid values
        clock.setHours(25); // Invalid hours
        clock.setMinutes(-5); // Invalid minutes
        clock.setSeconds(61); // Invalid seconds
        clock.displayTime(); // Output: Current Time: 0:0:0 (default values applied)

        // Use getters to retrieve and display individual values
        System.out.println("Hours: " + clock.getHours()); // Output: Hours: 0
        System.out.println("Minutes: " + clock.getMinutes()); // Output: Minutes: 0
        System.out.println("Seconds: " + clock.getSeconds()); // Output: Seconds: 0
    }
}
