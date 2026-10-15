package Lab1;

class Address {
    String city;
}
public class Person {
    String name;
    Address address;
    public static void main(String[] args) {
        // 1. Working chained expression
        Person p1 = new Person();
        p1.name = "Nyasha";
        p1.address = new Address();
        p1.address.city = "Harare";

        // EXPLAIN: Evaluates left to right: p1 -> gets address object -> gets city string
        System.out.println(p1.name + " lives in " + p1.address.city);

        // 2. Demonstrating NullPointerException
        Person p2 = new Person();
        p2.name = "Tafadzwa";
        // We purposefully FORGET to initialize the address: p2.address = new Address();
        try {
            System.out.println(p2.name + " lives in " + p2.address.city);
        } catch (NullPointerException e) {
            System.out.println("Error: " + p2.name + "'s address is null! Cannot access .city");
        }
    }
}