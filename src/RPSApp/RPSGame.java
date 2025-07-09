package RPSApp;

import java.util.Scanner;

/**
 * Rock Paper Scissors game implementation.
 */
@Info(
        author = "YourName",
        version = "1.0",
        description = "A modern console Rock Paper Scissors game in Java."
)
public class RPSGame implements Playable {

    /**
     * Runs the Rock Paper Scissors game.
     */
    @Override
    public void run() {
        printMetadata();

        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("Type ROCK, PAPER, or SCISSORS to play. Type EXIT to quit.");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Your move: ");
                String input = scanner.nextLine().trim().toUpperCase();

                if (input.equals("EXIT")) {
                    System.out.println("Thanks for playing!");
                    break;
                }

                Move playerMove;
                try {
                    playerMove = Move.valueOf(input);
                } catch (IllegalArgumentException e) {
                    throw new GameException("Invalid move. Please type ROCK, PAPER, or SCISSORS.");
                }

                Move computerMove = Move.randomMove();
                System.out.printf("Computer chose: %s%n", computerMove);

                Result result = playerMove.playAgainst(computerMove);
                System.out.printf("Result: You %s!%n%n", result);
            }
        } catch (GameException e) {
            System.err.println("Game Error: " + e.getMessage());
        }
    }

    /**
     * Prints game metadata from the custom Info annotation.
     */
    private void printMetadata() {
        Info info = this.getClass().getAnnotation(Info.class);
        if (info != null) {
            System.out.println("=== Game Info ===");
            System.out.printf("Author      : %s%n", info.author());
            System.out.printf("Version     : %s%n", info.version());
            System.out.printf("Description : %s%n", info.description());
            System.out.println("=================\n");
        }
    }
}
