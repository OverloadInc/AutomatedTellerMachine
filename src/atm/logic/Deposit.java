package atm.logic;

import atm.bank.Bank;
import atm.parts.DepositSlot;
import atm.parts.DisplayScreen;
import atm.parts.Keypad;

public class Deposit extends Transaction {
    private double amount;
    private Keypad keypad;
    private DepositSlot depositSlot;
    private static final int CANCELED = 0;

    public Deposit(int accountNumber, DisplayScreen displayScreen, Bank bank, Keypad keypad, DepositSlot depositSlot) {
        super(accountNumber, displayScreen, bank);
        this.keypad = keypad;
        this.depositSlot = depositSlot;
    }

    public void execute() {
        this.amount = this.promptForDeposit();
        if (this.amount != 0.0D) {
            this.displayScreen.displayMessage("\nInsert a deposit envelope containing ");
            this.displayScreen.displayAmount(this.amount);
            this.displayScreen.displayMessageLine(".");
            boolean envelopeReceived = this.depositSlot.isEnvelopeReceived();
            if (envelopeReceived) {
                this.displayScreen.displayMessageLine("\nYour envelope has been received.");
                this.bank.credit(this.getAccountNumber(), this.amount);
            } else {
                this.displayScreen.displayMessageLine("\nYou did not insert an envelope");
                this.displayScreen.displayMessageLine("\nThe transaction was canceled");
            }
        } else {
            this.displayScreen.displayMessageLine("\nCanceling transaction...");
        }

    }

    private double promptForDeposit() {
        this.displayScreen.displayMessage("\nEnter a deposit amount or digit 0 to cancel: ");
        int input = this.keypad.getInput();
        return input == 0 ? 0.0D : (double)input;
    }
}
