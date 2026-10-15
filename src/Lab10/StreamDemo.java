package Lab10;

import java.util.*;

record Student(String name, double mark) {}

public class StreamDemo {
    public static void main(String[] args) {
        System.out.println("--- Basic 2: removeIf ---");
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        nums.removeIf(n -> n % 2 == 0); // Predicate Lambda
        System.out.println("Odd numbers only: " + nums);

        System.out.println("\n--- Intermediate 2: Stream API ---");
        List<Student> students = List.of(
                new Student("Alice", 60), new Student("Bob", 85),
                new Student("Charlie", 40), new Student("Diana", 90)
        );

        double avg = students.stream().mapToDouble(Student::mark).average().orElse(0);
        System.out.println("Class Average: " + avg);

        System.out.println("Students above average (sorted):");
        students.stream()
                .filter(s -> s.mark() > avg)
                .sorted(Comparator.comparing(Student::name))
                .forEach(s -> System.out.println(s.name()));
    }
}