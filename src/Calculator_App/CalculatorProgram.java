package Calculator_App;

import java.util.Scanner;

/**
 * Handles the user interface and program flow of the calculator.
 */
public class CalculatorProgram {
    private final Scanner scanner = new Scanner(System.in);
    private final Calculator calculator = new Calculator();

    /**
     * Starts the calculator program loop.
     */
    public void run() {
        System.out.println("Welcome to Java Calculator!");

        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> performOperation("add");
                case "2" -> performOperation("subtract");
                case "3" -> performOperation("multiply");
                case "4" -> performOperation("divide");
                case "5" -> {
                    System.out.println("Exiting calculator. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Prints the calculator menu.
     */
    private void printMenu() {
        System.out.println("\n=== Calculator Menu ===");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
        System.out.print("Choose an operation: ");
    }

    /**
     * Handles input and performs the specified operation.
     * @param operation the type of calculation to perform
     */
    private void performOperation(String operation) {
        System.out.print("Enter first number: ");
        double a = Utils.readDouble(scanner);

        System.out.print("Enter second number: ");
        double b = Utils.readDouble(scanner);

        double result = switch (operation) {
            case "add" -> calculator.add(a, b);
            case "subtract" -> calculator.subtract(a, b);
            case "multiply" -> calculator.multiply(a, b);
            case "divide" -> calculator.divide(a, b);
            default -> Double.NaN;
        };

        System.out.println("Result: " + result);
    }
}