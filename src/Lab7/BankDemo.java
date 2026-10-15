package Lab7;

// Custom Checked Exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) { super(msg); }
}

class BankAccount {
    private double balance = 100.0;

    // EXPLAIN: throws declaration forces callers to handle this checked exception
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Shortfall of $" + (amount - balance));
        }
        balance -= amount;
        System.out.println("Withdrew $" + amount + ". Remaining: $" + balance);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        try {
            acc.withdraw(50);
            acc.withdraw(100); // This will throw
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}