package atm.parts;

/**
 * <code>DisplayScreen</code>
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class DisplayScreen {

    /**
     *
     */
    public DisplayScreen() {
    }

    /**
     *
     * @param message
     */
    public void displayMessage(String message) {
        System.out.print(message);
    }

    /**
     *
     * @param message
     */
    public void displayMessageLine(String message) {
        System.out.println(message);
    }

    /**
     *
     * @param amount
     */
    public void displayAmount(double amount) {
        System.out.printf("$%,.2f", amount);
    }
}