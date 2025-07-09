package NumberGuessing_App;

/**
 * Main class - Entry point for the Number Guessing Game application.
 */
public class Main {
    public static void main(String[] args) {
        // Initialize game configuration using the GameConfig record
        GameConfig config = new GameConfig(1, 100, 8);

        // Create the game instance
        NumberGuessingGame game = new NumberGuessingGame(config);

        // Run the game
        game.run();
    }
}
