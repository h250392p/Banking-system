package Lab2;

public class Temperature {
    private final double kelvin; // Storing internally as a single source of truth

    // EXPLAIN: Private constructor forces callers to use the static methods
    private Temperature(double kelvin) {
        this.kelvin = kelvin;
    }

    // EXPLAIN: Static factory methods
    public static Temperature fromCelsius(double celsius) {
        return new Temperature(celsius + 273.15);
    }

    public static Temperature fromFahrenheit(double fahrenheit) {
        return new Temperature((fahrenheit - 32) * 5.0 / 9.0 + 273.15);
    }

    public double getCelsius() { return kelvin - 273.15; }

    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(25);
        Temperature t2 = Temperature.fromFahrenheit(77);

        System.out.printf("T1 in Celsius: %.2f%n", t1.getCelsius());
        System.out.printf("T2 in Celsius: %.2f%n", t2.getCelsius());
    }
}