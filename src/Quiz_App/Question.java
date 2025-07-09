package Quiz_App;

/**
 * Record representing a quiz question.
 * Immutable data structure introduced in Java 14+.
 *
 * @param questionText The question text.
 * @param correctAnswer The correct answer.
 * @param difficulty Difficulty level of the question.
 */
public record Question(String questionText, String correctAnswer, Difficulty difficulty) {
}
