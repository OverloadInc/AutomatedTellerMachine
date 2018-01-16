package atm.bank;

public class Authentication {
    private static Bank bank = new Bank();

    public Authentication() {
    }

    public static boolean isValidUser(int accountNumber, int pin) {
        return bank.validateUser(accountNumber, pin);
    }
}
