package Madlibs_App;

/**
 * Base class for all games. Can be extended for shared behavior.
 */
public abstract class Game {
    protected void printWelcome(String gameName) {
        System.out.println("🎮 Welcome to " + gameName + " 🎮");
    }
}