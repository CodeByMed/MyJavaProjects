package TemperatureConverter_App;

/**
 * Record defining a conversion pair between two temperature units.
 *
 * @param from The source unit
 * @param to   The target unit
 */
public record ConversionType(TemperatureUnit from, TemperatureUnit to) { }
