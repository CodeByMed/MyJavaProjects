package Banking_App;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Bank, that handles the Contacts.
 */
public class Bank {
    private final String name;
    private final Map<Integer, BankAccount> accounts = new HashMap<>();

    public Bank(String name) {
        this.name = name;
    }

    public BankAccount createAccount(String owner) {
        BankAccount account = new BankAccount(owner);
        accounts.put(account.getId(), account);
        return account;
    }

    public boolean depositToAccount(int id, double amount) {
        BankAccount account = accounts.get(id);
        if (account != null) {
            account.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdrawFromAccount(int id, double amount) {
        BankAccount account = accounts.get(id);
        return account != null && account.withdraw(amount);
    }

    public Double getBalance(int id) {
        BankAccount account = accounts.get(id);
        return account != null ? account.getBalance() : null;
    }
}
