package Lab6;

interface Flyable { void fly(); }
class Bird implements Flyable {
    public void fly() { System.out.println("Bird flaps wings"); }
}
class Aeroplane implements Flyable {
    public void fly() { System.out.println("Aeroplane starts engines"); }
}

// Challenge: Default method conflict
interface A { default void hello() { System.out.println("Hello from A"); } }
interface B { default void hello() { System.out.println("Hello from B"); } }

class C implements A, B {
    @Override
    public void hello() {
        // EXPLAIN: Resolves the conflict by explicitly calling A's default method
        A.super.hello();
    }
}