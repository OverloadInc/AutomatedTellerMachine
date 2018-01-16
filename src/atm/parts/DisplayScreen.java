package atm.parts;

public class DisplayScreen {
    public DisplayScreen() {
    }

    public void displayMessage(String message) {
        System.out.print(message);
    }

    public void displayMessageLine(String message) {
        System.out.println(message);
    }

    public void displayAmount(double amount) {
        System.out.printf("$%,.2f", amount);
    }
}
