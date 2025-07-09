package TemperatureConverter_App;

/**
 * Implementation of TemperatureConverterService with basic conversion logic.
 */
public class StandardConverter implements TemperatureConverterService {

    @Override
    public Temperature convert(Temperature input, ConversionType type) throws InvalidTemperatureException {
        double value = input.value();
        TemperatureUnit from = type.from();
        TemperatureUnit to = type.to();

        if (from == to) return new Temperature(value, to);

        double result = switch (from) {
            case CELSIUS -> switch (to) {
                case FAHRENHEIT -> value * 9 / 5 + 32;
                case KELVIN -> value + 273.15;
                default -> throw unsupported(from, to);
            };
            case FAHRENHEIT -> switch (to) {
                case CELSIUS -> (value - 32) * 5 / 9;
                case KELVIN -> (value - 32) * 5 / 9 + 273.15;
                default -> throw unsupported(from, to);
            };
            case KELVIN -> switch (to) {
                case CELSIUS -> value - 273.15;
                case FAHRENHEIT -> (value - 273.15) * 9 / 5 + 32;
                default -> throw unsupported(from, to);
            };
        };

        return new Temperature(result, to);
    }

    private InvalidTemperatureException unsupported(TemperatureUnit from, TemperatureUnit to) {
        return new InvalidTemperatureException("Unsupported conversion: " + from + " to " + to);
    }
}
