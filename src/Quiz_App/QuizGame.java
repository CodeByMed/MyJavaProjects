package Quiz_App;

import java.util.List;
import java.util.Scanner;

/**
 * QuizGame class implementing Playable interface.
 * Contains the main quiz game loop.
 */
@Info(
        author = "CodeByMed",
        version = "1.0",
        description = "A simple Java console-based quiz game."
)
public class QuizGame implements Playable {

    private final List<Question> questions = List.of(
            new Question("What is the capital of France?", "Paris", Difficulty.EASY),
            new Question("What is 9 * 9?", "81", Difficulty.EASY),
            new Question("Who wrote '1984'?", "George Orwell", Difficulty.MEDIUM),
            new Question("What is the square root of 256?", "16", Difficulty.MEDIUM),
            new Question("What is the atomic number of Helium?", "2", Difficulty.HARD)
    );

    /**
     * Runs the quiz game.
     */
    @Override
    public void run() {
        printGameInfo();

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("Answer the following questions:\n");

        try (Scanner scanner = new Scanner(System.in)) {
            int score = 0;

            for (Question q : questions) {
                validateQuestion(q);

                System.out.printf("Question (%s): %s%n", q.difficulty(), q.questionText());
                System.out.print("Your answer: ");
                String userAnswer = scanner.nextLine().trim();

                if (userAnswer.equalsIgnoreCase(q.correctAnswer())) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.printf("Incorrect. Correct answer: %s%n%n", q.correctAnswer());
                }
            }

            System.out.printf("Quiz Over! Your Score: %d/%d%n", score, questions.size());
        }
    }

    /**
     * Validates if the question is properly set.
     * Throws InvalidQuestionException if any property is invalid.
     *
     * @param q The question to validate.
     */
    private void validateQuestion(Question q) {
        if (q.questionText() == null || q.questionText().isBlank()) {
            throw new InvalidQuestionException("Question text cannot be empty.");
        }
        if (q.correctAnswer() == null || q.correctAnswer().isBlank()) {
            throw new InvalidQuestionException("Correct answer cannot be empty.");
        }
        if (q.difficulty() == null) {
            throw new InvalidQuestionException("Difficulty must be specified.");
        }
    }

    /**
     * Prints game metadata using reflection to read the Info annotation.
     */
    private void printGameInfo() {
        Info info = this.getClass().getAnnotation(Info.class);
        if (info != null) {
            System.out.println("=== Game Info ===");
            System.out.printf("Author      : %s%n", info.author());
            System.out.printf("Version     : %s%n", info.version());
            System.out.printf("Description : %s%n", info.description());
            System.out.println("================\n");
        }
    }
}
