package Quiz_App;

/**
 * Custom exception for handling invalid quiz questions.
 */
public class InvalidQuestionException extends RuntimeException {
    public InvalidQuestionException(String message) {
        super(message);
    }
}
