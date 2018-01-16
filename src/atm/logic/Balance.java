package atm.logic;

import atm.bank.Bank;
import atm.parts.DisplayScreen;

public class Balance extends Transaction {
    public Balance(int accountNumber, DisplayScreen displayScreen, Bank bank) {
        super(accountNumber, displayScreen, bank);
    }

    public void execute() {
        double availableBalance = this.bank.getAvailableBalance(this.getAccountNumber());
        double totalBalance = this.bank.getTotalBalance(this.getAccountNumber());
        this.displayScreen.displayMessageLine("\nBalance Information:");
        this.displayScreen.displayMessage("\tAvailable balance: ");
        this.displayScreen.displayAmount(availableBalance);
        this.displayScreen.displayMessage("\n\tTotal balance: ");
        this.displayScreen.displayAmount(totalBalance);
        this.displayScreen.displayMessageLine("");
    }
}
