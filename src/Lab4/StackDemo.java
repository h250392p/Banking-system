package Lab4;

import java.util.ArrayList;

// BAD DESIGN: Inheritance
class BadStack<T> extends ArrayList<T> {
    public void push(T item) { add(item); }
    public T pop() { return remove(size() - 1); }
}

// GOOD DESIGN: Composition (HAS-A relationship)
class GoodStack<T> {
    // EXPLAIN: The list is hidden (encapsulated).
    private final ArrayList<T> list = new ArrayList<>();

    public void push(T item) { list.add(item); }
    public T pop() { return list.remove(list.size() - 1); }
}

public class StackDemo {
    public static void main(String[] args) {
        BadStack<String> bad = new BadStack<>();
        bad.push("A");
        bad.push("B");
        bad.clear(); // EXPLAIN: BadStack wrongly exposes ArrayList methods! A stack shouldn't be clearable this way.

        GoodStack<String> good = new GoodStack<>();
        good.push("A");
        good.push("B");
        // good.clear(); // COMPILE ERROR: Safe! GoodStack only exposes push and pop.
        System.out.println("Good stack popped: " + good.pop());
    }
}