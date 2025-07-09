package Banking_App;

/**
 * Represents a customer's bank account.
 */
public class BankAccount {
    private static int idCounter = 1000;

    private final int id;
    private final String owner;
    private double balance;

    public BankAccount(String owner) {
        this.id = idCounter++;
        this.owner = owner;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}