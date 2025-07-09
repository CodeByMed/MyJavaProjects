package NumberGuessing_App;

import java.util.Random;
import java.util.Scanner;

/**
 * The core game class implementing the Playable interface.
 * Contains the main game loop and logic.
 */
public class NumberGuessingGame implements Playable {

    private final GameConfig config;
    private final int targetNumber;

    /**
     * Constructor initializes game configuration and the target number.
     * @param config Game configuration (min, max, maxAttempts)
     */
    public NumberGuessingGame(GameConfig config) {
        this.config = config;
        this.targetNumber = generateRandomNumber();
    }

    /**
     * Generates a random target number within the configured range.
     * @return the random target number
     */
    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(config.max() - config.min() + 1) + config.min();
    }

    /**
     * Runs the number guessing game loop.
     */
    @Override
    public void run() {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.printf("Guess a number between %d and %d.%n", config.min(), config.max());

        try (Scanner scanner = new Scanner(System.in)) {
            for (int attempt = 1; attempt <= config.maxAttempts(); attempt++) {
                System.out.printf("Attempt %d of %d: ", attempt, config.maxAttempts());

                if (!scanner.hasNextInt()) {
                    throw new GameException("Invalid input. Please enter an integer.");
                }

                int guess = scanner.nextInt();
                GuessResult result = checkGuess(guess);

                if (result == GuessResult.CORRECT) {
                    System.out.println("Congratulations! You guessed the number!");
                    return;
                } else if (result == GuessResult.TOO_LOW) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            System.out.printf("You've used all attempts. The correct number was %d.%n", targetNumber);

        } catch (GameException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Compares the player's guess to the target number.
     * @param guess The player's guess.
     * @return GuessResult indicating whether the guess is too low, too high, or correct.
     */
    private GuessResult checkGuess(int guess) {
        if (guess < config.min() || guess > config.max()) {
            throw new GameException("Guess out of range! Please guess within the specified range.");
        }

        if (guess == targetNumber) {
            return GuessResult.CORRECT;
        } else if (guess < targetNumber) {
            return GuessResult.TOO_LOW;
        } else {
            return GuessResult.TOO_HIGH;
        }
    }
}
