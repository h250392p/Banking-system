package Lab3;

public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        setMarks(marks); // EXPLAIN: Reuse validation in the constructor
    }

    public String getName() { return name; }
    public int getMarks() { return marks; }

    public void setMarks(int marks) {
        // EXPLAIN: Validation ensures the object cannot be put into an invalid state
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    // EXPLAIN: Calculated property. We don't store `grade` as a field because it
    // strictly depends on `marks`. This prevents data inconsistency.
    public String getGrade() {
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        return "F";
    }

    public static void main(String[] args) {
        Student s = new Student("Tatenda", 75);
        System.out.println(s.getName() + " got a " + s.getGrade());

        try {
            s.setMarks(105); // Will throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
