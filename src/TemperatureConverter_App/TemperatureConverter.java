package TemperatureConverter_App;

import java.util.Scanner;

/**
 * Main controller and UI layer for temperature conversion.
 */
@AppInfo(
        author = "CodeByMed",
        version = "1.0",
        description = "Modern console-based temperature converter."
)
public class TemperatureConverter {

    private final Scanner scanner = new Scanner(System.in);
    private final TemperatureConverterService converter = new StandardConverter();

    public void run() {
        printMetadata();

        System.out.println("🌡️ Welcome to the Java Temperature Converter!");

        while (true) {
            try {
                System.out.println("\nEnter value (e.g. 100) or type 'exit' to quit:");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("👋 Goodbye!");
                    break;
                }

                double value = Double.parseDouble(input);

                TemperatureUnit fromUnit = askUnit("Convert from");
                TemperatureUnit toUnit = askUnit("Convert to");

                ConversionType type = new ConversionType(fromUnit, toUnit);

                Temperature inputTemp = new Temperature(value, fromUnit);
                Temperature resultTemp = converter.convert(inputTemp, type);

                System.out.printf("✅ Result: %.2f %s = %.2f %s\n",
                        inputTemp.value(), fromUnit.symbol(),
                        resultTemp.value(), toUnit.symbol()
                );

            } catch (NumberFormatException e) {
                System.err.println("❌ Invalid number. Please enter a numeric value.");
            } catch (InvalidTemperatureException e) {
                System.err.println("⚠️ Error: " + e.getMessage());
            }
        }
    }

    private TemperatureUnit askUnit(String prompt) {
        System.out.println(prompt + " unit? (C, F, K):");
        return TemperatureUnit.fromSymbol(scanner.nextLine().trim());
    }

    private void printMetadata() {
        AppInfo info = this.getClass().getAnnotation(AppInfo.class);
        if (info != null) {
            System.out.println("""
                    ==============================
                    Author      : %s
                    Version     : %s
                    Description : %s
                    ==============================
                    """.formatted(info.author(), info.version(), info.description()));
        }
    }
}
