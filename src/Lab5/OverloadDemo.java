package Lab5;

import java.util.Arrays;

public class OverloadDemo {

    public void print(int i) { System.out.println("Integer: " + i); }
    public void print(double d) { System.out.println("Double: " + d); }
    public void print(String s) { System.out.println("String: " + s); }
    public void print(int[] arr) { System.out.println("Array: " + Arrays.toString(arr)); }

    public static void main(String[] args) {
        OverloadDemo demo = new OverloadDemo();
        demo.print(10);
        demo.print(5.5);
        demo.print("Hello");
        demo.print(new int[]{1, 2, 3});
    }
}