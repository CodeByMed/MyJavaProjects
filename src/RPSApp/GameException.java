package RPSApp;

/**
 * Custom exception used for invalid game input or configuration.
 */
public class GameException extends RuntimeException {
  public GameException(String message) {
    super(message);
  }
}
