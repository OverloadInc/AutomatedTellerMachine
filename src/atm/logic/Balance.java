package atm.logic;

import atm.bank.Bank;
import atm.parts.DisplayScreen;

public class Balance extends Transaction {

    public Balance(int accountNumber, DisplayScreen displayScreen, Bank bank) {
        super(accountNumber, displayScreen, bank);
    }

    public void execute() {
        double availableBalance = bank.getAvailableBalance(getAccountNumber());
        double totalBalance = bank.getTotalBalance(getAccountNumber());

        displayScreen.displayMessageLine("\nBalance Information:");
        displayScreen.displayMessage("\tAvailable balance: ");
        displayScreen.displayAmount(availableBalance);
        displayScreen.displayMessage("\n\tTotal balance: ");
        displayScreen.displayAmount(totalBalance);
        displayScreen.displayMessageLine("");
    }
}