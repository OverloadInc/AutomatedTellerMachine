package atm.bank;

public class Bank {
    private final Account[] accounts = new Account[2];

    public Bank() {
        this.accounts[0] = new Account(12345, 54321, 1000.0D, 1000.0D);
        this.accounts[1] = new Account(56789, 98765, 2000.0D, 2000.0D);
    }

    private Account getAccount(int accountNumber) {
        Account[] var2 = this.accounts;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Account currentAccount = var2[var4];
            if (currentAccount.getAccountNumber() == accountNumber) {
                return currentAccount;
            }
        }

        return null;
    }

    public boolean validateUser(int accountNumber, int pin) {
        Account account = this.getAccount(accountNumber);
        return account != null ? account.validatePIN(pin) : false;
    }

    public double getAvailableBalance(int accountNumber) {
        return this.getAccount(accountNumber).getAvailableBalance();
    }

    public double getTotalBalance(int accountNumber) {
        return this.getAccount(accountNumber).getTotalBalance();
    }

    public void credit(int accountNumber, double amount) {
        this.getAccount(accountNumber).credit(amount);
    }

    public void debit(int accountNumber, double amount) {
        this.getAccount(accountNumber).debit(amount);
    }
}
