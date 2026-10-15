package Lab8;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        System.out.println("--- Basic 1: ArrayList Math ---");
        List<Integer> numbers = new ArrayList<>(List.of(5, 10, 15, 20, 25, 30, 35, 40, 45, 50));
        int sum = 0, max = numbers.get(0);
        for (int n : numbers) {
            sum += n;
            if (n > max) max = n;
        }
        Collections.reverse(numbers);
        System.out.println("Sum: " + sum + ", Max: " + max + ", Reversed: " + numbers);

        System.out.println("\n--- Basic 2: Remove Duplicates ---");
        List<String> names = List.of("Ali", "Zoe", "Ali", "Bob");
        Set<String> uniqueNames = new HashSet<>(names);
        System.out.println("Unique names: " + uniqueNames);

        System.out.println("\n--- Intermediate 2: Word Frequency Map ---");
        String text = "hello world hello java world java java";
        Map<String, Integer> freq = new HashMap<>();
        for (String word : text.split(" ")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        System.out.println("Frequencies: " + freq);
    }
}