package Banking_App;

import java.util.Scanner;

/**
 * The core of the banking application.
 * Manages user interaction and connects to the banking logic.
 */
public class BankingProgram {

    private final Scanner scanner = new Scanner(System.in);
    private final Bank bank = new Bank("Banking Program");

    public void run() {
        System.out.println("Welcome to Java Bank!");
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> createAccount();
                case "2" -> deposit();
                case "3" -> withdraw();
                case "4" -> checkBalance();
                case "5" -> {
                    System.out.println("Thank you for using Java Bank.");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n==== Main Menu ====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }

    private void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        BankAccount account = bank.createAccount(name);
        System.out.println("Account created successfully. Your account ID is: " + account.getId());
    }

    private void deposit() {
        System.out.print("Enter account ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (bank.depositToAccount(id, amount)) {
            System.out.println("Deposit successful.");
        }
        else {
            System.out.println("Account not found.");
        }
    }

    private void withdraw () {
        System.out.print("Enter account ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (bank.withdrawFromAccount(id, amount)) {
            System.out.println("Withdrawal successful.");
        }
        else {
            System.out.println("Withdrawal failed (check account ID or balance).");
        }
    }

    private void checkBalance() {
        System.out.print("Enter account ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Double balance = bank.getBalance(id);

        if (balance != null) {
            System.out.println("Current balance: $" + balance);
        }
        else {
            System.out.println("Account not found.");
        }
    }
}
