package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

    public static int[] readInputNumbers() {
        String input = readFromConsole();
        String[] splitedStrings = splitByDelimiters(input);
        return parseInt(splitedStrings);
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

    private static int[] parseInt(String[] inputs) {
        /* 음수 값일 때 등 입력값 예외처리 필요 */
        return Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
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
