package atm.bank;

public class Bank {
    private final Account[] accounts = new Account[2];

    public Bank() {
        accounts[0] = new Account(12345, 54321, 1000.0D, 1000.0D);
        accounts[1] = new Account(56789, 98765, 2000.0D, 2000.0D);
    }

    private Account getAccount(int accountNumber) {
        for(int i = 0; i < accounts.length; ++i) {
            Account currentAccount = accounts[i];

            if (currentAccount.getAccountNumber() == accountNumber)
                return currentAccount;
        }

        return null;
    }

    public boolean validateUser(int accountNumber, int pin) {
        Account account = getAccount(accountNumber);

        return account != null ? account.validatePIN(pin) : false;
    }

    public double getAvailableBalance(int accountNumber) {
        return getAccount(accountNumber).getAvailableBalance();
    }

    public double getTotalBalance(int accountNumber) {
        return getAccount(accountNumber).getTotalBalance();
    }

    public void credit(int accountNumber, double amount) {
        getAccount(accountNumber).credit(amount);
    }

    public void debit(int accountNumber, double amount) {
        getAccount(accountNumber).debit(amount);
    }
}