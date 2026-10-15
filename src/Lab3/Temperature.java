package Lab3;

public class Temperature {
    // EXPLAIN: Internals can change (e.g., to Celsius) without breaking outside code.
    // Callers only interact with getCelsius(), setCelsius(), etc.
    private double kelvin;

    public Temperature(double kelvin) {
        setKelvin(kelvin);
    }

    private void setKelvin(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Temperature cannot be below absolute zero (0 K)");
        }
        this.kelvin = kelvin;
    }

    public double getCelsius() { return kelvin - 273.15; }
    public double getFahrenheit() { return (kelvin - 273.15) * 9/5 + 32; }

    public void setCelsius(double celsius) { setKelvin(celsius + 273.15); }
    public void setFahrenheit(double fahrenheit) { setKelvin((fahrenheit - 32) * 5/9 + 273.15); }
}
