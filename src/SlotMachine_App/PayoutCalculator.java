package SlotMachine_App;

/**
 * Calculates winnings based on SpinResult.
 */
public class PayoutCalculator {

    /**
     * Returns the payout value based on a spin result.
     */
    public int calculate(SpinResult result) {
        if (result.isJackpot()) {
            return result.winningSymbol().payout();
        }
        return 0;
    }
}
