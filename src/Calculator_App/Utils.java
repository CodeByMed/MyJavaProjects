package Calculator_App;

import java.util.Scanner;

/**
 * Utility class with helper methods for input handling and validation.
 */
public class Utils {
    /**
     * Reads a double from the scanner and handles invalid input.
     * @param scanner Scanner object for input
     * @return validated double input
     */

    public static double readDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter a valid number: ");
            }
        }
    }
}