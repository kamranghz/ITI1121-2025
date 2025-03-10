import java.util.StringTokenizer;
import java.util.NoSuchElementException;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor to initialize the time
    public Time(int h, int m, int s) {
        this.hours = h;
        this.minutes = m;
        this.seconds = s;
    }

    /**
     * Parses a string containing a time format (HH:MM:SS)
     * and converts it into a Time object.
     * 
     * It handles invalid formats by throwing a custom TimeFormatException.
     */
    public static Time parseTime(String timeString) {
        // Tokenizing the timeString using ":" as a separator
        StringTokenizer st = new StringTokenizer(timeString, ":", true);
        int h, m, s;

        // Parsing the hours field
        try {
            h = Integer.parseInt(st.nextToken()); // Extract the first token
        } catch (NumberFormatException e1) {
            throw new TimeFormatException("First field is not a number");
        } catch (NoSuchElementException e2) {
            throw new TimeFormatException("First separator not found");
        }

        // Checking first separator
        try {
            st.nextToken();
        } catch (NoSuchElementException e2) {
            throw new TimeFormatException("First separator not found");
        }

        // Parsing the minutes field
        try {
            m = Integer.parseInt(st.nextToken());
        } catch (NumberFormatException e1) {
            throw new TimeFormatException("Second field is not a number");
        } catch (NoSuchElementException e2) {
            throw new TimeFormatException("Second separator not found");
        }

        // Checking second separator
        try {
            st.nextToken();
        } catch (NoSuchElementException e2) {
            throw new TimeFormatException("Second separator not found");
        }

        // Parsing the seconds field
        try {
            s = Integer.parseInt(st.nextToken());
        } catch (NumberFormatException e1) {
            throw new TimeFormatException("Third field is not a number");
        } catch (NoSuchElementException e2) {
            throw new TimeFormatException("Third field not found");
        }

        // If there are extra tokens after parsing, it's an invalid format
        if (st.hasMoreTokens()) {
            throw new TimeFormatException("Invalid suffix detected in time format");
        }

        // Ensuring the values are within valid time range
        if ((h < 0) || (h > 23) || (m < 0) || (m > 59) || (s < 0) || (s > 59)) {
            throw new TimeFormatException("Values out of range: " + timeString);
        }

        // Return a valid Time object
        return new Time(h, m, s);
    }

    // Override toString() method to display time in HH:MM:SS format
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void main(String[] args) {
        // Testing the parseTime method with valid and invalid inputs
        try {
            Time t1 = Time.parseTime("14:30:45"); // Valid time
            System.out.println("Parsed time: " + t1);
        } catch (TimeFormatException e) {
            System.err.println("Time parsing error: " + e.getMessage());
        }

        try {
            Time t2 = Time.parseTime("25:61:70"); // Invalid values
            System.out.println("Parsed time: " + t2);
        } catch (TimeFormatException e) {
            System.err.println("Time parsing error: " + e.getMessage());
        }

        try {
            Time t3 = Time.parseTime("12:45"); // Missing seconds
            System.out.println("Parsed time: " + t3);
        } catch (TimeFormatException e) {
            System.err.println("Time parsing error: " + e.getMessage());
        }

        try {
            Time t4 = Time.parseTime("09-30-15"); // Wrong separator
            System.out.println("Parsed time: " + t4);
        } catch (TimeFormatException e) {
            System.err.println("Time parsing error: " + e.getMessage());
        }
    }
}
