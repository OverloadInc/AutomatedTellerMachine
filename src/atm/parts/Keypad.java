package atm.parts;

import java.util.Scanner;

/**
 * <code>Keypad</code>
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class Keypad {

    private Scanner input;

    /**
     *
     */
    public Keypad() {
        input = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public int getInput() {
        return input.nextInt();
    }
}