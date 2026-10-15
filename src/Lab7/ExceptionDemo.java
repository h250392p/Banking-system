package Lab7;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Basic 1: Division ---");
        try {
            System.out.print("Enter numerator: ");
            int num = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int den = scanner.nextInt();
            System.out.println("Result: " + (num / den));
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }

        System.out.println("\n--- Basic 2: Array Out of Bounds ---");
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds!");
        }

        System.out.println("\n--- Challenge: Return vs Finally ---");
        System.out.println("Method returned: " + testFinally());
    }

    static int testFinally() {
        try {
            return 1; // EXPLAIN: Even with a return here, finally runs BEFORE returning.
        } finally {
            System.out.println("Finally block executed!");
        }
    }
}