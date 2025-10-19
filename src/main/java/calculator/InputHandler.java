package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static void readInputNumbers() {
        readFromConsole();
    }

    private static String readFromConsole() {
        return Console.readLine();
    }
}
