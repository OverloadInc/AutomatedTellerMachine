package atm;

import atm.front.ATMConsole;

/**
 * <code>Main</code>
 * @author Overload Inc.
 * @version 1.0, 23 Jan 2022
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String... args) {
        ATMConsole atmConsole = new ATMConsole();
        atmConsole.run();
    }
}