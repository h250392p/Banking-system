package Lab1;

public class Rectangle {
    double width;
    double height;

    double area() { return width * height; }
    double perimeter() { return 2 * (width + height); }

    public static void main(String[] args) {
        // --- Intermediate 1: Array of Rectangles ---
        Rectangle[] rects = new Rectangle[5];

        for(int i = 0; i < 5; i++) {
            rects[i] = new Rectangle();
        }

        rects[0].width = 2; rects[0].height = 3;  // Area: 6
        rects[1].width = 4; rects[1].height = 5;  // Area: 20
        rects[2].width = 10; rects[2].height = 2; // Area: 20
        rects[3].width = 7; rects[3].height = 8;  // Area: 56
        rects[4].width = 5; rects[4].height = 5;  // Area: 25

        Rectangle largest = rects[0];
        for (Rectangle r : rects) {
            if (r.area() > largest.area()) {
                largest = r;
            }
        }
        System.out.println("Largest Area: " + largest.area() + " (W:" + largest.width + ", H:" + largest.height + ")");

        // --- Intermediate 2: Aliasing Prediction ---
        System.out.println("\n--- Aliasing Test ---");
        Rectangle r1 = new Rectangle();
        r1.width = 10;

        Rectangle r2 = r1; // EXPLAIN: Copies the reference, not the object. They are aliases.
        r2.width = 99;

        // Prediction: r1.width will be 99 because r1 and r2 point to the EXACT SAME object in memory.
        System.out.println("r1.width is: " + r1.width);
    }
}
