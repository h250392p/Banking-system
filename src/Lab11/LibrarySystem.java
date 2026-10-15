package Lab11;

import java.util.*;

// 1. Custom Exceptions
class ItemNotAvailableException extends Exception {
    public ItemNotAvailableException(String msg) { super(msg); }
}
class MemberLimitExceededException extends Exception {
    public MemberLimitExceededException(String msg) { super(msg); }
}

// 2. Interface
interface Borrowable {
    void borrow(Member m) throws ItemNotAvailableException;
    void giveBack();
}

// 3. Abstract Class
abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        this.id = id; this.title = title;
    }

    public abstract int loanPeriodDays();
    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }

    @Override
    public void borrow(Member m) throws ItemNotAvailableException {
        if (!available) throw new ItemNotAvailableException(title + " is currently checked out.");
        available = false;
    }

    @Override
    public void giveBack() { available = true; }

    @Override
    public String toString() { return "[" + id + "] " + title + " (Avail: " + available + ")"; }
}

// 4. Concrete Subclasses
class Book extends LibraryItem {
    public Book(String id, String title) { super(id, title); }
    @Override public int loanPeriodDays() { return 14; }
}

class Dvd extends LibraryItem {
    public Dvd(String id, String title) { super(id, title); }
    @Override public int loanPeriodDays() { return 3; }
}

// 5. Member Class
class Member {
    private final String memberId;
    private final String name;
    private int borrowedCount = 0;

    public Member(String id, String name) { this.memberId = id; this.name = name; }
    public String getId() { return memberId; }
    public String getName() { return name; }

    public void borrowItem() throws MemberLimitExceededException {
        if (borrowedCount >= 3) throw new MemberLimitExceededException(name + " reached max limit (3).");
        borrowedCount++;
    }

    public void returnItem() {
        if (borrowedCount > 0) borrowedCount--;
    }
}

// 6. Library Service Class
class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();

    public void addItem(LibraryItem item) { items.put(item.getId(), item); }
    public void addMember(Member member) { members.put(member.getId(), member); }

    public void borrow(String memberId, String itemId) {
        try {
            Member m = members.get(memberId);
            LibraryItem item = items.get(itemId);

            if (m == null || item == null) throw new IllegalArgumentException("Invalid ID");

            m.borrowItem();    // Throws if over limit
            item.borrow(m);    // Throws if unavailable

            System.out.println("SUCCESS: " + m.getName() + " borrowed '" + item.getTitle() + "'");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void search(String keyword) {
        System.out.println("\nSearch results for '" + keyword + "':");
        items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .forEach(System.out::println);
    }
}

// 7. Main Application
public class LibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library();

        // Setup data
        lib.addItem(new Book("B1", "Effective Java"));
        lib.addItem(new Book("B2", "Clean Code"));
        lib.addItem(new Dvd("D1", "Java Tutorial Video"));

        lib.addMember(new Member("M1", "Kenneth"));

        // Test Logic
        lib.search("Java"); // Streams

        System.out.println("\n--- Borrowing ---");
        lib.borrow("M1", "B1");
        lib.borrow("M1", "B1"); // Should fail (Not Available)

        lib.borrow("M1", "B2");
        lib.borrow("M1", "D1");
        lib.borrow("M1", "B3"); // Should fail (Invalid ID)
    }
}