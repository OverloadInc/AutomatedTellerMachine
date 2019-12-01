package atm.logic;

import atm.bank.Bank;
import atm.front.ATMGraphic;
import atm.parts.DepositSlot;
import atm.parts.DisplayScreen;
import atm.parts.Keypad;

public class Deposit extends Transaction {
    private double amount;
    private Keypad keypad;
    private DepositSlot depositSlot;

    public Deposit(int accountNumber, DisplayScreen displayScreen, Bank bank, Keypad keypad, DepositSlot depositSlot) {
        super(accountNumber, displayScreen, bank);
        this.keypad = keypad;
        this.depositSlot = depositSlot;
    }

    public void execute() {
        amount = promptForDeposit();

        if (amount != 0.0D) {
            displayScreen.displayMessage("\nInsert a deposit envelope containing ");
            displayScreen.displayAmount(amount);
            displayScreen.displayMessageLine(".");

            boolean envelopeReceived = depositSlot.isEnvelopeReceived();

            if (envelopeReceived) {
                displayScreen.displayMessageLine("\nYour envelope has been received.");
                bank.credit(getAccountNumber(), amount);
            }
            else {
                displayScreen.displayMessageLine("\nYou did not insert an envelope");
                displayScreen.displayMessageLine("\nThe transaction was canceled");
            }
        }
        else {
            displayScreen.displayMessageLine("\nCanceling transaction...");
        }
    }

    public void execute(double amount) {
        if (amount != 0.0D) {
            boolean envelopeReceived = depositSlot.isEnvelopeReceived();

            if (envelopeReceived) {
                ATMGraphic.setDepositAmount("Your envelope has been received.");

                bank.credit(getAccountNumber(), amount);
            }
            else {
                ATMGraphic.setDepositAmount("\nYou did not insert an envelope\nThe transaction was canceled");
            }
        }
        else {
            ATMGraphic.setDepositAmount("\nCanceling transaction...");
        }
    }

    private double promptForDeposit() {
        displayScreen.displayMessage("\nEnter a deposit amount or digit 0 to cancel: ");
        int input = keypad.getInput();

        return input == 0 ? 0.0D : (double)input;
    }
}