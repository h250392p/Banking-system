package Lab1;

public class Car {
    String brand;
    int year;
    double mileage;

    void display() {
        System.out.println(brand + " (" + year + ") - Mileage: " + mileage + "km");
    }

    boolean isAntique() {
        return (2026 - year) > 25;
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota Corolla"; c1.year = 2015; c1.mileage = 85000;

        Car c2 = new Car();
        c2.brand = "Ford Mustang"; c2.year = 1967; c2.mileage = 120000;

        c1.display(); System.out.println("Is Antique? " + c1.isAntique());
        c2.display(); System.out.println("Is Antique? " + c2.isAntique());
    }
}
