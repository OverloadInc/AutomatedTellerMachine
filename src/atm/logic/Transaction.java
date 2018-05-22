package atm.logic;

import atm.bank.Bank;
import atm.parts.DisplayScreen;

public abstract class Transaction {
    protected int accountNumber;
    protected DisplayScreen displayScreen;
    protected Bank bank;

    public Transaction(int accountNumber, DisplayScreen displayScreen, Bank bank) {
        this.accountNumber = accountNumber;
        this.displayScreen = displayScreen;
        this.bank = bank;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public DisplayScreen getScreen() {
        return displayScreen;
    }

    public Bank getBankDatabase() {
        return bank;
    }

    protected abstract void execute();
}