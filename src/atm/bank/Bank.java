package atm.bank;

/**
 * <code>Bank</code>
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class Bank {
    private final Account[] accounts = new Account[2];

    /**
     *
     */
    public Bank() {
        accounts[0] = new Account(12345, 54321, 1000.0D, 1000.0D);
        accounts[1] = new Account(56789, 98765, 2000.0D, 2000.0D);
    }

    /**
     *
     * @param accountNumber
     * @return
     */
    private Account getAccount(int accountNumber) {
        for(int i = 0; i < accounts.length; ++i) {
            Account currentAccount = accounts[i];

            if (currentAccount.getAccountNumber() == accountNumber)
                return currentAccount;
        }

        return null;
    }

    /**
     *
     * @param accountNumber
     * @param pin
     * @return
     */
    public boolean validateUser(int accountNumber, int pin) {
        Account account = getAccount(accountNumber);

        return account != null ? account.validatePIN(pin) : false;
    }

    /**
     *
     * @param accountNumber
     * @return
     */
    public double getAvailableBalance(int accountNumber) {
        return getAccount(accountNumber).getAvailableBalance();
    }

    /**
     *
     * @param accountNumber
     * @return
     */
    public double getTotalBalance(int accountNumber) {
        return getAccount(accountNumber).getTotalBalance();
    }

    /**
     *
     * @param accountNumber
     * @param amount
     */
    public void credit(int accountNumber, double amount) {
        getAccount(accountNumber).credit(amount);
    }

    /**
     *
     * @param accountNumber
     * @param amount
     */
    public void debit(int accountNumber, double amount) {
        getAccount(accountNumber).debit(amount);
    }
}