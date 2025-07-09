package NumberGuessing_App;

/**
 * Custom runtime exception for handling game-specific errors.
 */
public class GameException extends RuntimeException {
    public GameException(String message) {
        super(message);
    }
}
