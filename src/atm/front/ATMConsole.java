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
    private Bank bank;
    private Keypad keypad;
    private DepositSlot depositSlot;
    private DisplayScreen displayScreen;
    private CashDispenser cashDispenser;
    private static final int BALANCE = 1;
    private static final int WITHDRAW = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    public ATMConsole() {
        bank = new Bank();
        keypad = new Keypad();
        depositSlot = new DepositSlot();
        displayScreen = new DisplayScreen();
        cashDispenser = new CashDispenser();
    }

    public void run() {
        while(true) {
            if (userAuthenticated) {
                promptForTransactions();
                userAuthenticated = false;
                currentAccountNumber = 0;
                displayScreen.displayMessageLine("\nThank you! Goodbye!");
            }
            else {
                displayScreen.displayMessageLine("\nWelcome!");
                authenticateUser();
            }
        }
    }

    private void authenticateUser() {
        displayScreen.displayMessage("\nEnter your account number: ");
        int accountNumber = keypad.getInput();

        displayScreen.displayMessage("\nEnter your PIN: ");
        int pin = keypad.getInput();

        userAuthenticated = Authentication.isValidUser(accountNumber, pin);

        if (userAuthenticated)
            currentAccountNumber = accountNumber;
        else
            displayScreen.displayMessageLine("\nInvalid account number or PIN. Please try again.");
    }

    private void promptForTransactions() {
        Transaction currentTransaction = null;
        boolean finished = false;

        while(!finished) {
            int option = displayMainMenu();

            switch(option) {
                case BALANCE:
                    currentTransaction = createTransaction(option);
                    ((Balance)currentTransaction).execute();
                    break;
                case WITHDRAW:
                    currentTransaction = createTransaction(option);
                    ((Withdraw)currentTransaction).execute();
                    break;
                case DEPOSIT:
                    currentTransaction = createTransaction(option);
                    ((Deposit)currentTransaction).execute();
                    break;
                case EXIT:
                    displayScreen.displayMessageLine("\nExiting the system...");
                    finished = true;
                    break;
                default:
                    displayScreen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
            }
        }
    }

    private int displayMainMenu() {
        displayScreen.displayMessageLine("\nMain menu:");
        displayScreen.displayMessageLine("\t(1) - View my balance");
        displayScreen.displayMessageLine("\t(2) - Withdraw cash");
        displayScreen.displayMessageLine("\t(3) - Deposit funds");
        displayScreen.displayMessageLine("\t(4) - Exit");
        displayScreen.displayMessage("\nEnter an option: ");

        return keypad.getInput();
    }

    private Transaction createTransaction(int option) {
        Transaction transaction = null;

        switch(option) {
            case BALANCE:
                transaction = new Balance(currentAccountNumber, displayScreen, bank);
                break;
            case WITHDRAW:
                transaction = new Withdraw(currentAccountNumber, displayScreen, bank, keypad, cashDispenser);
                break;
            case DEPOSIT:
                transaction = new Deposit(currentAccountNumber, displayScreen, bank, keypad, depositSlot);
        }

        return (Transaction)transaction;
    }
}