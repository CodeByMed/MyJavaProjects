package Calculator_App;

/**
 * Contains core arithmetic operations for the calculator.
 */
public class Calculator {
    /**
     * Adds two numbers.
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first.
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides the first number by the second.
     * Throws an exception if division by zero is attempted.
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot Divide by zero.");
        }
        return a / b;
    }
}

