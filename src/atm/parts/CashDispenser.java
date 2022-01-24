package atm.parts;

/**
 * <code>CashDispenser</code>
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class CashDispenser {
    private static final int INITIAL_COUNT = 500;
    private int billsRemaining = 500;

    /**
     *
     */
    public CashDispenser() {
    }

    /**
     *
     * @param amount
     */
    public void dispenseCash(int amount) {
        int billsRequired = amount / 20;
        billsRemaining -= billsRequired;
    }

    /**
     *
     * @param amount
     * @return
     */
    public boolean isSufficientCashAvailable(int amount) {
        int billsRequired = amount / 20;

        return billsRemaining >= billsRequired;
    }
}