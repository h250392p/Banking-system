package Lab2;

public class Circle {
    private double radius;
    // EXPLAIN: Shared across all Circle objects
    private static int circleCount = 0;

    // Constructor with parameter
    public Circle(double radius) {
        this.radius = radius;
        circleCount++;
    }

    // No-argument constructor
    public Circle() {
        this(1.0); // EXPLAIN: Constructor chaining. Calls Circle(double radius)
    }

    public static int getCircleCount() {
        return circleCount;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(5.5);
        Circle c2 = new Circle(); // Uses default 1.0
        Circle c3 = new Circle(10.2);

        System.out.println("Total circles created: " + Circle.getCircleCount());
    }
}
