import java.util.Scanner;
import java.util.InputMismatchException;

// 1. Abstract Account Class
abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("SUCCESS: Deposited $" + amount + " into " +
                    accountNumber + ". New balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("ERROR: Deposit amount must be strictly positive.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public abstract void withdraw(double amount);
    public abstract void endOfMonth();
}

// 2. SavingsAccount Class
class SavingsAccount extends Account {
    private double minimumBalance;
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double minimumBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("ERROR: Withdrawal amount must be positive.");
            return;
        }

        // Reject if the withdrawal drops the balance below the minimum
        if (balance - amount < minimumBalance) {
            System.out.println("DECLINED: Withdrawal of $" + amount + " rejected for Savings Account "
                    + accountNumber +
                    ". Balance cannot drop below the minimum of $" + minimumBalance +
                    ". Current balance: $" + String.format("%.2f", balance));
        } else {
            balance -= amount;
            System.out.println("SUCCESS: Withdrew $" + amount + " from Savings Account "
                    + accountNumber + ". New balance: $" + String.format("%.2f", balance));
        }
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("End of Month [Savings]: " + accountNumber + " earned $" +
                String.format("%.2f", interest) + " in interest. New balance: $" + String.format("%.2f", balance));
    }
}

// 3. CurrentAccount Class
class CurrentAccount extends Account {
    private double overdraftLimit;
    private double maintenanceFee;

    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit, double maintenanceFee) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
        this.maintenanceFee = maintenanceFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("ERROR: Withdrawal amount must be positive.");
            return;
        }

        // Allow negative balance, but reject if it drops below the negative overdraft limit
        if (balance - amount < -overdraftLimit) {
            System.out.println("DECLINED: Withdrawal of $" + amount + " rejected for Current Account " + accountNumber +
                    ". Exceeds overdraft limit of $" + overdraftLimit +
                    ". Current balance: $" + String.format("%.2f", balance));
        } else {
            balance -= amount;
            System.out.println("SUCCESS: Withdrew $" + amount + " from Current Account " + accountNumber + ". New balance: $" + String.format("%.2f", balance));
        }
    }

    @Override
    public void endOfMonth() {
        balance -= maintenanceFee;
        System.out.println("End of Month [Current]: " + accountNumber + " was charged a $" +
                String.format("%.2f", maintenanceFee) + " maintenance fee. New balance: $" + String.format("%.2f", balance));
    }
}

// 4. Main Interactive Demo Class
public class BankDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize Accounts
        Account savings = new SavingsAccount("SA-101", 1000.0, 200.0, 0.05); // Min balance $200
        Account current = new CurrentAccount("CA-201", 500.0, 500.0, 15.0);  // Overdraft limit $500

        System.out.println("Welcome to the Java Banking System!");

        while (true) {
            try {
                // Main Menu
                System.out.println("\n========== MAIN MENU ==========");
                System.out.println("1. Access Savings Account (SA-101)");
                System.out.println("2. Access Current Account (CA-201)");
                System.out.println("3. Fast-forward to End of Month (Process all accounts)");
                System.out.println("4. Exit");
                System.out.print("Please select an option (1-4): ");

                int mainChoice = scanner.nextInt();

                if (mainChoice == 4) {
                    System.out.println("Thank you for banking with us. Goodbye!");
                    break; // Exit the loop and end the program
                } else if (mainChoice == 3) {
                    System.out.println("\n--- Processing End of Month ---");
                    savings.endOfMonth();
                    current.endOfMonth();
                    continue;
                }

                // Determine which account to pass into the secondary menu
                Account selectedAccount = null;
                if (mainChoice == 1) {
                    selectedAccount = savings;
                } else if (mainChoice == 2) {
                    selectedAccount = current;
                } else {
                    System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
                    continue;
                }

                // Sub-Menu for the selected account
                boolean inAccountMenu = true;
                while (inAccountMenu) {
                    System.out.println("\n--- Account: " + selectedAccount.getAccountNumber() + " ---");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Back to Main Menu");
                    System.out.print("What would you like to do? (1-4): ");

                    int actionChoice = scanner.nextInt();

                    switch (actionChoice) {
                        case 1:
                            System.out.print("Enter amount to deposit: $");
                            double depositAmount = scanner.nextDouble();
                            selectedAccount.deposit(depositAmount);
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: $");
                            double withdrawAmount = scanner.nextDouble();
                            selectedAccount.withdraw(withdrawAmount);
                            break;
                        case 3:
                            System.out.println("Current Balance: $" + String.format("%.2f", selectedAccount.getBalance()));
                            break;
                        case 4:
                            inAccountMenu = false; // Exits this loop and goes back to Main Menu
                            break;
                        default:
                            System.out.println("Invalid choice. Please select 1-4.");
                    }
                }
            } catch (InputMismatchException e) {
                // Catches the error if the user types a letter instead of a number
                System.out.println("ERROR: Invalid input! Please enter numbers only.");
                scanner.next(); // Clear the bad input from the scanner
            }
        }

        scanner.close();
    }
}