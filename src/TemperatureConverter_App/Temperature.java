package TemperatureConverter_App;

/**
 * Immutable temperature value object.
 *
 * @param value The numeric value
 * @param unit  The unit (Celsius, Fahrenheit, etc.)
 */
public record Temperature(double value, TemperatureUnit unit) { }
