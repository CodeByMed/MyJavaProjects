package SlotMachine_App;

/**
 * Record representing the result of a slot machine spin.
 *
 * @param symbols The 3 symbols from the spin.
 */
public record SpinResult(Symbol[] symbols) {

    public boolean isJackpot() {
        return symbols.length == 3 &&
                symbols[0] == symbols[1] &&
                symbols[1] == symbols[2];
    }

    public Symbol winningSymbol() {
        return isJackpot() ? symbols[0] : null;
    }
}
