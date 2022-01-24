package atm.logic;

import atm.bank.Bank;
import atm.parts.DisplayScreen;

/**
 * <code>Transaction</code>
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public abstract class Transaction {
    protected int accountNumber;
    protected DisplayScreen displayScreen;
    protected Bank bank;

    /**
     *
     * @param accountNumber
     * @param displayScreen
     * @param bank
     */
    public Transaction(int accountNumber, DisplayScreen displayScreen, Bank bank) {
        this.accountNumber = accountNumber;
        this.displayScreen = displayScreen;
        this.bank = bank;
    }

    /**
     *
     * @return
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     *
     * @return
     */
    public DisplayScreen getScreen() {
        return displayScreen;
    }

    /**
     *
     * @return
     */
    public Bank getBankDatabase() {
        return bank;
    }

    /**
     *
     */
    protected abstract void execute();

    /**
     *
     * @param amount
     */
    protected abstract void execute(double amount);
}