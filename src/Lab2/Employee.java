package Lab2;

public class Employee {
    private static int idGenerator = 0;

    private final int employeeId;
    private String name;
    private String role;

    // EXPLAIN: Instance block runs before ANY constructor
    {
        idGenerator++;
        employeeId = idGenerator;
    }

    // 1. Full constructor
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // 2. Partial constructor
    public Employee(String name) {
        this(name, "Unassigned"); // Chains to full constructor
    }

    // 3. No-arg constructor
    public Employee() {
        this("Unknown"); // Chains to partial constructor
    }

    // 4. Copy constructor
    public Employee(Employee other) {
        this.name = other.name;
        this.role = other.role;
        // EXPLAIN: It still gets a UNIQUE ID because the instance block increments idGenerator
    }

    public void display() {
        System.out.println("ID: " + employeeId + " | Name: " + name + " | Role: " + role);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "Manager");
        Employee e2 = new Employee("Bob");
        Employee e3 = new Employee(e1); // Copy of Alice

        e1.display();
        e2.display();
        e3.display(); // Will have same name/role as e1, but ID will be 3
    }
}