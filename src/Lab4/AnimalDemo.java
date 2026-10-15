package Lab4;

class Animal {
    private String name;
    public Animal(String name) { this.name = name; }
    public String getName() { return name; }
}

class Dog extends Animal {
    // EXPLAIN: Because Animal only has `Animal(String name)`,
    // we MUST provide a constructor that calls `super(name)`.
    // A default no-argument constructor would fail here.
    public Dog(String name) {
        super(name);
    }
}

public class AnimalDemo {
    public static void main(String[] args) {
        Dog d = new Dog("Bingo");
        System.out.println("Dog's name is: " + d.getName());
    }
}