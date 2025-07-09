package SlotMachine_App;

import java.util.Random;

/**
 * Simulates a spinning reel that returns 3 random slot symbols.
 */
public class Reel {

    private final Symbol[] symbols = Symbol.values();
    private final Random random = new Random();

    public Symbol[] spin() throws SlotMachineException {
        if (symbols.length == 0) {
            throw new SlotMachineException("No symbols available on reel.");
        }

        Symbol[] result = new Symbol[3];
        for (int i = 0; i < 3; i++) {
            result[i] = symbols[random.nextInt(symbols.length)];
        }
        return result;
    }
}
