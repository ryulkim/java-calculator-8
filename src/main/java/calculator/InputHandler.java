package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

    public static void readInputNumbers() {
        String input = readFromConsole();
        String[] splitedStrings = splitByDelimiters(input);
    }

    private static String readFromConsole() {
        return Console.readLine();
    }

    private static String[] splitByDelimiters(String input) {
        String regex = ",|:";

        String[] customDelimiters = extractCustomDelimiterAndRemains(input);
        if (customDelimiters != null) {
            /* customDelimiter가 특수문자일 경우 예외 처리 필요 */
            regex += "|" + customDelimiters[0];
            input = customDelimiters[1];
        }

        return input.split(regex);
    }

    private static String[] extractCustomDelimiterAndRemains(String input) {
        Pattern pattern = Pattern.compile("^//(.*?)\\R(.*)$", Pattern.DOTALL);
        input = input.replace("\\n", "\n");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return new String[]{matcher.group(1), matcher.group(2)};
        }
        return null;
    }
}
