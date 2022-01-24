package atm.logic;

import atm.bank.Bank;
import atm.front.ATMGraphic;
import atm.parts.DisplayScreen;

/**
 * <code>Balance</code>
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class Balance extends Transaction {

    /**
     *
     * @param accountNumber
     * @param displayScreen
     * @param bank
     */
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

    public void execute(double amount) {
        double availableBalance = bank.getAvailableBalance(getAccountNumber());
        double totalBalance = bank.getTotalBalance(getAccountNumber());

        ATMGraphic.setAvailableBalance(availableBalance);
        ATMGraphic.setTotalBalance(totalBalance);
    }
}