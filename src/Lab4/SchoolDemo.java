package Lab4;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.print("Name: " + name + ", Age: " + age);
    }
}

class Student extends Person {
    private String course;

    public Student(String name, int age, String course) {
        super(name, age); // EXPLAIN: Must be the first line; calls Person's constructor
        this.course = course;
    }

    @Override
    public void display() {
        super.display(); // Reuse parent's display logic
        System.out.println(" | Course: " + course); // Then extend it
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(" | Subject: " + subject);
    }
}

public class SchoolDemo {
    public static void main(String[] args) {
        Student s = new Student("Chipo", 20, "Computer Science");
        Teacher t = new Teacher("Mr. Moyo", 45, "Mathematics");

        s.display();
        t.display();
    }
}