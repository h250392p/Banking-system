package Lab5;

class Animal {
    String type = "Generic Animal"; // Field
    void sound() { System.out.println("..."); }
}
class Cat extends Animal {
    String type = "Cat";
    @Override void sound() { System.out.println("Meow"); }
}
class Cow extends Animal {
    @Override void sound() { System.out.println("Moo"); }
}
class Duck extends Animal {
    @Override void sound() { System.out.println("Quack"); }
}

public class AnimalDemo {
    public static void main(String[] args) {
        Animal[] animals = { new Cat(), new Cow(), new Duck() };
        for (Animal a : animals) {
            a.sound();
        }

        System.out.println("\n--- Intermediate 2: Field vs Method ---");
        Animal myCat = new Cat();
        myCat.sound();

        System.out.println(myCat.type); // Prints "Generic Animal", NOT "Cat"
    }
}