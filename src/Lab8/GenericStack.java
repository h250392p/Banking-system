package Lab8;

import java.util.ArrayList;

public class GenericStack<T> {
    private final ArrayList<T> elements = new ArrayList<>();

    public void push(T item) { elements.add(item); }
    public T pop() { return elements.remove(elements.size() - 1); }
    public T peek() { return elements.get(elements.size() - 1); }
    public boolean isEmpty() { return elements.isEmpty(); }

    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        stack.push("Java");
        stack.push("OOP");
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is Empty? " + stack.isEmpty());
    }
}