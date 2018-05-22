package atm.bank;

public class Authentication {
    private static Bank bank;

    public Authentication() {
        bank = new Bank();
    }

    public static boolean isValidUser(int accountNumber, int pin) {
        return bank.validateUser(accountNumber, pin);
    }
}