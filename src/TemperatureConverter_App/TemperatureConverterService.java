package TemperatureConverter_App;

/**
 * Interface defining temperature conversion behavior.
 */
public interface TemperatureConverterService {
    Temperature convert(Temperature input, ConversionType type) throws InvalidTemperatureException;
}
