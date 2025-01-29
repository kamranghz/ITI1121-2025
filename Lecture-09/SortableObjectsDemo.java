// Main class to test our implementation
public class SortableObjectsDemo {
    public static void main(String[] args) {
        // Testing Time class comparison
        System.out.println("=== Comparing Time Objects ===");
        Time t1 = new Time(2, 30, 0);  // 2 hours 30 minutes
        Time t2 = new Time(1, 45, 0);  // 1 hour 45 minutes

        int result = t1.compareTo(t2);
        if (result < 0) {
            System.out.println("Time t1 is earlier than t2");
        } else if (result > 0) {
            System.out.println("Time t1 is later than t2");
        } else {
            System.out.println("Time t1 is the same as t2");
        }

        // Testing Shape comparison
        System.out.println("\n=== Comparing Shapes ===");
        Shape rect = new Rectangle(5, 10); // Area = 50
        Shape circ = new Circle(4);       // Area = π * 4^2 = 50.24

        int shapeCompare = rect.compareTo(circ);
        if (shapeCompare < 0) {
            System.out.println("Rectangle has a smaller area than Circle");
        } else if (shapeCompare > 0) {
            System.out.println("Rectangle has a larger area than Circle");
        } else {
            System.out.println("Rectangle and Circle have the same area");
        }

        // Sorting Comparable objects
        System.out.println("\n=== Sorting Time Objects ===");
        Time[] times = { new Time(3, 0, 0), new Time(1, 30, 0) };
        SortUtility.sort2(times);
        System.out.println("After sorting:");
        for (Time t : times) {
            System.out.println(t);
        }
    }
}

// 1. Base Class SortableObject (Instead of Comparable)
class SortableObject {
    public int compareTo(Object obj) {
        return 0; // Default: No meaningful comparison
    }
}

// 2. Implementing the Time class
class Time extends SortableObject {
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor
    public Time(int h, int m, int s) {
        this.hours = h;
        this.minutes = m;
        this.seconds = s;
    }

    // Convert time to total seconds
    public int getTotalSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    // Implementing compareTo method to compare Time objects
    @Override
    public int compareTo(Object obj) {
        if (obj instanceof Time) {
            Time other = (Time) obj;
            return Integer.compare(this.getTotalSeconds(), other.getTotalSeconds());
        }
        return 0; // Return 0 if not a Time object
    }

    // String representation of Time
    @Override
    public String toString() {
        return hours + "h " + minutes + "m " + seconds + "s";
    }
}

// 3. Implementing the SortableObject class for Shapes
abstract class Shape extends SortableObject {
    public abstract double area();

    @Override
    public int compareTo(Object obj) {
        if (obj instanceof Shape) {
            Shape other = (Shape) obj;
            return Double.compare(this.area(), other.area());
        }
        return 0; // Return 0 if not a Shape object
    }
}

// 4. Implementing Rectangle as a subclass of Shape
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle with width " + width + " and height " + height;
    }
}

// 5. Implementing Circle as a subclass of Shape
class Circle extends Shape {
    private double radius;

    public Circle(double r) {
        this.radius = r;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle with radius " + radius;
    }
}

// 6. Implementing Sort Utility for sorting SortableObject objects
class SortUtility {
    public static void sort2(SortableObject[] a) {
        if (a[0].compareTo(a[1]) > 0) {
            SortableObject temp = a[0];
            a[0] = a[1];
            a[1] = temp;
        }
    }
}








