package atm.front;

import atm.bank.Authentication;
import atm.bank.Bank;
import atm.logic.Balance;
import atm.logic.Deposit;
import atm.logic.Transaction;
import atm.logic.Withdraw;
import atm.parts.CashDispenser;
import atm.parts.DepositSlot;
import atm.parts.DisplayScreen;
import atm.parts.Keypad;

public class ATMConsole {
    private boolean userAuthenticated = false;
    private int currentAccountNumber = 0;
    private DisplayScreen displayScreen = new DisplayScreen();
    private Keypad keypad = new Keypad();
    private CashDispenser cashDispenser = new CashDispenser();
    private DepositSlot depositSlot = new DepositSlot();
    private Bank bank = new Bank();
    private static final int BALANCE = 1;
    private static final int WITHDRAW = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    public ATMConsole() {
    }

    public void run() {
        while(true) {
            if (!this.userAuthenticated) {
                this.displayScreen.displayMessageLine("\nWelcome!");
                this.authenticateUser();
            } else {
                this.promptForTransactions();
                this.userAuthenticated = false;
                this.currentAccountNumber = 0;
                this.displayScreen.displayMessageLine("\nThank you! Goodbye!");
            }
        }
    }

    private void authenticateUser() {
        this.displayScreen.displayMessage("\nEnter your account number: ");
        int accountNumber = this.keypad.getInput();
        this.displayScreen.displayMessage("\nEnter your PIN: ");
        int pin = this.keypad.getInput();
        this.userAuthenticated = Authentication.isValidUser(accountNumber, pin);
        if (this.userAuthenticated) {
            this.currentAccountNumber = accountNumber;
        } else {
            this.displayScreen.displayMessageLine("\nInvalid account number or PIN. Please try again.");
        }

    }

    private void promptForTransactions() {
        Transaction currentTransaction = null;
        boolean finished = false;

        while(!finished) {
            int option = this.displayMainMenu();
            switch(option) {
                case 1:
                    currentTransaction = this.createTransaction(option);
                    ((Balance)currentTransaction).execute();
                    break;
                case 2:
                    currentTransaction = this.createTransaction(option);
                    ((Withdraw)currentTransaction).execute();
                    break;
                case 3:
                    currentTransaction = this.createTransaction(option);
                    ((Deposit)currentTransaction).execute();
                    break;
                case 4:
                    this.displayScreen.displayMessageLine("\nExiting the system...");
                    finished = true;
                    break;
                default:
                    this.displayScreen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
            }
        }

    }

    private int displayMainMenu() {
        this.displayScreen.displayMessageLine("\nMain menu:");
        this.displayScreen.displayMessageLine("\t(1) - View my balance");
        this.displayScreen.displayMessageLine("\t(2) - Withdraw cash");
        this.displayScreen.displayMessageLine("\t(3) - Deposit funds");
        this.displayScreen.displayMessageLine("\t(4) - Exit");
        this.displayScreen.displayMessage("\nEnter an option: ");
        return this.keypad.getInput();
    }

    private Transaction createTransaction(int option) {
        Transaction transaction = null;
        switch(option) {
            case 1:
                transaction = new Balance(this.currentAccountNumber, this.displayScreen, this.bank);
                break;
            case 2:
                transaction = new Withdraw(this.currentAccountNumber, this.displayScreen, this.bank, this.keypad, this.cashDispenser);
                break;
            case 3:
                transaction = new Deposit(this.currentAccountNumber, this.displayScreen, this.bank, this.keypad, this.depositSlot);
        }

        return (Transaction)transaction;
    }
}
