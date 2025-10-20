package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    public static int[] getNumbersByDelimiter(String input) {
        String[] splitedStrings = splitByDelimiters(input);
        return NumberValidator.parseInt(splitedStrings);
    }

    private static String[] splitByDelimiters(String input) {
        String regex = ",|:";

        String[] customDelimiters = extractCustomDelimiterAndRemains(input);
        if (customDelimiters != null && validDelimiter(customDelimiters[0])) {
            /* customDelimiter가 특수문자일 경우 예외 처리 필요 */
            regex += "|" + customDelimiters[0];
            input = customDelimiters[1];
        }

        return input.split(regex);
    }

    private static boolean validDelimiter(String delimiter) {
        if (delimiter.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("커스텀 문자에 숫자가 포함되면 안됩니다.");
        }
        return true;
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
