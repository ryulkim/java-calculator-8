package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static int[] readInputNumbers() {
        String input = readFromConsole();
        return DelimiterParser.getNumbersByDelimiter(input);
    }

    private static String readFromConsole() {
        return Console.readLine();
    }


}
