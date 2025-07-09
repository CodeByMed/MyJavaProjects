package RPSApp;

import java.util.Random;

/**
 * Enum representing possible moves in the game.
 */
public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    /**
     * Generates a random move for the computer.
     * @return a random Move.
     */
    public static Move randomMove() {
        Move[] moves = values();
        return moves[new Random().nextInt(moves.length)];
    }

    /**
     * Determines the outcome against another move.
     * @param opponentMove The move to compare with.
     * @return The result of the current move against the opponent's move.
     */
    public Result playAgainst(Move opponentMove) {
        if (this == opponentMove) return Result.DRAW;

        return switch (this) {
            case ROCK -> (opponentMove == SCISSORS) ? Result.WIN : Result.LOSE;
            case PAPER -> (opponentMove == ROCK) ? Result.WIN : Result.LOSE;
            case SCISSORS -> (opponentMove == PAPER) ? Result.WIN : Result.LOSE;
        };
    }
}