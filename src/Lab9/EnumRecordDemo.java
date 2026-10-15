package Lab9;

enum Level { LOW, MEDIUM, HIGH }

// Record automatically generates constructor, equals, hashCode, and toString
record Student(String name, int age) {}

public class EnumRecordDemo {
    public static void main(String[] args) {
        Level current = Level.HIGH;
        switch (current) {
            case LOW -> System.out.println("Take it easy.");
            case MEDIUM -> System.out.println("Steady pace.");
            case HIGH -> System.out.println("Maximum effort!");
        }

        Student s1 = new Student("Tariro", 21);
        Student s2 = new Student("Tariro", 21);
        System.out.println(s1);
        System.out.println("Are they equal? " + s1.equals(s2)); // true
    }
}