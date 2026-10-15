package Lab3;

// EXPLAIN: 1. 'final' class prevents subclasses from overriding methods to change behavior
public final class ImmutablePerson {
    // EXPLAIN: 2. 'private' hides data, 'final' ensures it is assigned exactly once
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // EXPLAIN: 3. Only getters are provided. No setters exist.
    public String getName() { return name; }
    public int getAge() { return age; }
}