package atm.bank;

/**
 * <code>Authentication</code>
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class Authentication {
    private static Bank bank = new Bank();

    /**
     *
     * @param accountNumber
     * @param pin
     * @return
     */
    public static boolean isValidUser(int accountNumber, int pin) {
        return bank.validateUser(accountNumber, pin);
    }
}