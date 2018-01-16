package atm.bank;

public class Account {
    private int accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;

    public Account(int accountNumber, int pin, double availableBalance, double totalBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getAvailableBalance() {
        return this.availableBalance;
    }

    public double getTotalBalance() {
        return this.totalBalance;
    }

    public boolean validatePIN(int pin) {
        return this.pin == pin;
    }

    public void credit(double amount) {
        this.totalBalance += amount;
    }

    public void debit(double amount) {
        this.availableBalance -= amount;
        this.totalBalance -= amount;
    }
}
