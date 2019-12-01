package atm.logic;

import atm.bank.Bank;
import atm.parts.CashDispenser;
import atm.parts.DisplayScreen;
import atm.parts.Keypad;

import javax.swing.*;

public class Withdraw extends Transaction {
    private int amount;
    private Keypad keypad;
    private CashDispenser cashDispenser;
    private static final int CANCELED = 6;

    public Withdraw(int accountNumber, DisplayScreen displayScreen, Bank bank, Keypad keypad, CashDispenser cashDispenser) {
        super(accountNumber, displayScreen, bank);
        this.keypad = keypad;
        this.cashDispenser = cashDispenser;
    }

    public void execute() {
        boolean cashDispensed = false;

        do {
            amount = this.promptForWithdraw();

            if (amount == CANCELED) {
                displayScreen.displayMessageLine("\nCanceling transaction...");

                return;
            }

            double availableBalance = bank.getAvailableBalance(getAccountNumber());

            if ((double)amount <= availableBalance) {
                if (cashDispenser.isSufficientCashAvailable(amount)) {
                    bank.debit(getAccountNumber(), (double)amount);
                    cashDispenser.dispenseCash(amount);
                    cashDispensed = true;
                    displayScreen.displayMessageLine("\nPlease take your cash.");
                }
                else {
                    displayScreen.displayMessageLine("\nInsufficient cash available in the ATM.");
                    displayScreen.displayMessageLine("\nPlease choose a smaller amount.");
                }
            }
            else {
                displayScreen.displayMessageLine("\nInsufficient funds in your account.");
                displayScreen.displayMessageLine("\nPlease choose a smaller amount.");
            }
        } while(!cashDispensed);
    }

    public void execute(double option) {
        int userOption = (int)option;
        int[] amountOptions = new int[]{0, 20, 40, 60, 100, 200};

        switch(userOption){
            case 1: case 2: case 3: case 4: case 5:
                amount = amountOptions[(int)option]; break;
            default:
                amount = userOption;
        }

        double availableBalance = bank.getAvailableBalance(getAccountNumber());

        if ((double)amount <= availableBalance) {
            if (cashDispenser.isSufficientCashAvailable((int) amount)) {
                bank.debit(getAccountNumber(), (double)amount);
                cashDispenser.dispenseCash((int) amount);

                JOptionPane.showMessageDialog(null, "\nPlease take your cash.");
            }
            else {
                JOptionPane.showMessageDialog(null, "\nInsufficient cash available in the ATM.\nPlease choose a smaller amount.");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "\nInsufficient funds in your account.\nPlease choose a smaller amount.");
        }
    }

    private int promptForWithdraw() {
        int[] amounts = new int[]{0, 20, 40, 60, 100, 200};
        int option = 0;

        while(option == 0) {
            displayScreen.displayMessageLine("\nWithdrawal menu:");
            displayScreen.displayMessageLine("\t(1) - $20");
            displayScreen.displayMessageLine("\t(2) - $40");
            displayScreen.displayMessageLine("\t(3) - $60");
            displayScreen.displayMessageLine("\t(4) - $100");
            displayScreen.displayMessageLine("\t(5) - $200");
            displayScreen.displayMessageLine("\t(6) - Cancel");
            displayScreen.displayMessage("\nChoose a withdrawal amount: ");
            int input = keypad.getInput();

            switch(input) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    option = amounts[input];
                    break;
                case 6:
                    option = 6;
                    break;
                default:
                    displayScreen.displayMessageLine("\nInvalid selection. Try again.");
            }
        }

        return option;
    }
}