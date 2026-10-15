package Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccount(double openingBalance) {
        this.balance = openingBalance;
        history.add("Account opened with: " + openingBalance);
    }

    public void deposit(double amount) {
        balance += amount;
        history.add("Deposited: " + amount);
    }

    // We return an unmodifiable list so callers can read the history
    // but cannot do `account.getHistory().clear()`, which would bypass encapsulation.
    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(100);
        acc.deposit(50);

        System.out.println("History:");
        for (String tx : acc.getHistory()) {
            System.out.println(tx);
        }

        try {
            acc.getHistory().add("Fake deposit: 1000000"); // Blocked!
        } catch (UnsupportedOperationException e) {
            System.out.println("Blocked attempt to alter history directly.");
        }
    }
}