package TemperatureConverter_App;

public enum TemperatureUnit {
    CELSIUS("C"),
    FAHRENHEIT("F"),
    KELVIN("K");

    private final String symbol;

    TemperatureUnit(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

    public static TemperatureUnit fromSymbol(String symbol) {
        return switch (symbol.toUpperCase()) {
            case "C" -> CELSIUS;
            case "F" -> FAHRENHEIT;
            case "K" -> KELVIN;
            default -> throw new IllegalArgumentException("Unsupported unit: " + symbol);
        };
    }
}
