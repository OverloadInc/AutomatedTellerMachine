package atm.parts;

public class CashDispenser {
    private static final int INITIAL_COUNT = 500;
    private int billsRemaining = 500;

    public CashDispenser() {
    }

    public void dispenseCash(int amount) {
        int billsRequired = amount / 20;
        this.billsRemaining -= billsRequired;
    }

    public boolean isSufficientCashAvailable(int amount) {
        int billsRequired = amount / 20;
        return this.billsRemaining >= billsRequired;
    }
}
