package TemperatureConverter_App;

/**
 * Exception for invalid or unsupported temperature conversions.
 */
public class InvalidTemperatureException extends Exception {
    public InvalidTemperatureException(String message) {
        super(message);
    }
}
