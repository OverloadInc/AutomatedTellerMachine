package atm.logic;

import atm.bank.Bank;
import atm.parts.CashDispenser;
import atm.parts.DisplayScreen;
import atm.parts.Keypad;

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
            this.amount = this.promptForWithdraw();
            if (this.amount == 6) {
                this.displayScreen.displayMessageLine("\nCanceling transaction...");
                return;
            }

            double availableBalance = this.bank.getAvailableBalance(this.getAccountNumber());
            if ((double)this.amount <= availableBalance) {
                if (this.cashDispenser.isSufficientCashAvailable(this.amount)) {
                    this.bank.debit(this.getAccountNumber(), (double)this.amount);
                    this.cashDispenser.dispenseCash(this.amount);
                    cashDispensed = true;
                    this.displayScreen.displayMessageLine("\nPlease take your cash.");
                } else {
                    this.displayScreen.displayMessageLine("\nInsufficient cash available in the ATM.");
                    this.displayScreen.displayMessageLine("\nPlease choose a smaller amount.");
                }
            } else {
                this.displayScreen.displayMessageLine("\nInsufficient funds in your account.");
                this.displayScreen.displayMessageLine("\nPlease choose a smaller amount.");
            }
        } while(!cashDispensed);

    }

    private int promptForWithdraw() {
        int[] amounts = new int[]{0, 20, 40, 60, 100, 200};
        int option = 0;

        while(option == 0) {
            this.displayScreen.displayMessageLine("\nWithdrawal menu:");
            this.displayScreen.displayMessageLine("\t(1) - $20");
            this.displayScreen.displayMessageLine("\t(2) - $40");
            this.displayScreen.displayMessageLine("\t(3) - $60");
            this.displayScreen.displayMessageLine("\t(4) - $100");
            this.displayScreen.displayMessageLine("\t(5) - $200");
            this.displayScreen.displayMessageLine("\t(6) - Cancel");
            this.displayScreen.displayMessage("\nChoose a withdrawal amount: ");
            int input = this.keypad.getInput();
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
                    this.displayScreen.displayMessageLine("\nInvalid selection. Try again.");
            }
        }

        return option;
    }
}
