package SlotMachine_App;

/**
 * Enum representing symbols on the slot machine reels.
 */
public enum Symbol {
    CHERRY("🍒", 20),
    LEMON("🍋", 10),
    SEVEN("7️⃣", 50),
    BELL("🔔", 30),
    BAR("💎", 100);

    private final String icon;
    private final int payout;

    Symbol(String icon, int payout) {
        this.icon = icon;
        this.payout = payout;
    }

    public String icon() {
        return icon;
    }

    public int payout() {
        return payout;
    }
}
