public class Date {
    private int day;
    private int month;

    // Constructor to initialize the day and month
    public Date(int day, int month) {
        this.day = day;
        this.month = month;
    }

    // Getter for the day
    public int getDay() {
        return day;
    }

    // Getter for the month
    public int getMonth() {
        return month;
    }

    // Method to return a string representation of the date
    public String toString() {
        return day + "/" + month;
    }

    // Main method to demonstrate creating and using a Date object
    public static void main(String[] args) {
        Date date = new Date(15, 10); // 15th October
        System.out.println("Date: " + date.toString());
        System.out.println("Day: " + date.getDay());
        System.out.println("Month: " + date.getMonth());
    }
}
