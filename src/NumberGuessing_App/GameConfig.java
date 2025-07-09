package NumberGuessing_App;

/**
 * Record representing the game configuration.
 * Contains minimum value, maximum value, and maximum number of attempts.
 * Immutable by design.
 * Introduced in Java 14+.
 *
 * Example:
 * GameConfig config = new GameConfig(1, 100, 5);
 */
public record GameConfig(int min, int max, int maxAttempts) { }
