package atm.bank;

/**
 * <code>Account</code>
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class Account {
    private int accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;

    /**
     *
     * @param accountNumber
     * @param pin
     * @param availableBalance
     * @param totalBalance
     */
    public Account(int accountNumber, int pin, double availableBalance, double totalBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
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
    public double getAvailableBalance() {
        return availableBalance;
    }

    /**
     *
     * @return
     */
    public double getTotalBalance() {
        return totalBalance;
    }

    /**
     *
     * @param pin
     * @return
     */
    public boolean validatePIN(int pin) {
        return this.pin == pin;
    }

    /**
     *
     * @param amount
     */
    public void credit(double amount) {
        totalBalance += amount;
    }

    /**
     *
     * @param amount
     */
    public void debit(double amount) {
        availableBalance -= amount;
        totalBalance -= amount;
    }
}