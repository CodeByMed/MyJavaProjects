package SlotMachine_App;

import java.util.Scanner;

/**
 * Handles the Slot Machine game loop, I/O, and credit tracking.
 */
@AppInfo(
        author = "CodeByMed",
        version = "2.0",
        description = "Professional console-based Java Slot Machine game."
)
public class SlotMachine implements Runnable {

    private final Reel reel = new Reel();
    private final PayoutCalculator payoutCalculator = new PayoutCalculator();
    private final Scanner scanner = new Scanner(System.in);
    private int credits = 100;

    @Override
    public void run() {
        printAppMetadata();
        System.out.println("🎰 Welcome to the Java Slot Machine!");
        System.out.println("You have 100 credits to start.\n");

        while (true) {
            System.out.println("Press [Enter] to spin (10 credits) or type 'exit' to quit:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing! Final credits: " + credits);
                break;
            }

            try {
                playOneRound();
            } catch (SlotMachineException e) {
                System.err.println("Game Error: " + e.getMessage());
                break;
            }
        }
    }

    private void playOneRound() throws SlotMachineException {
        if (credits < 10) {
            throw new SlotMachineException("Not enough credits to spin.");
        }

        credits -= 10;
        Symbol[] spinSymbols = reel.spin();
        SpinResult result = new SpinResult(spinSymbols);

        printSpin(result);

        int winnings = payoutCalculator.calculate(result);
        credits += winnings;

        System.out.printf("You %s %d credits. Current credits: %d\n\n",
                winnings > 0 ? "won" : "lost", winnings, credits);
    }

    private void printSpin(SpinResult result) {
        System.out.print("Spin: ");
        for (Symbol symbol : result.symbols()) {
            System.out.print("| " + symbol.icon() + " ");
        }
        System.out.println("|");
    }

    private void printAppMetadata() {
        AppInfo info = this.getClass().getAnnotation(AppInfo.class);
        if (info != null) {
            System.out.println("""
                    === Game Metadata ===
                    Author      : %s
                    Version     : %s
                    Description : %s
                    =======================
                    """.formatted(info.author(), info.version(), info.description()));
        }
    }
}
