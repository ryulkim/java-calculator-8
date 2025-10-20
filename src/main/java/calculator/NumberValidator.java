package calculator;

import java.util.Arrays;

public class NumberValidator {

    public static int[] parseInt(String[] inputs) throws IllegalArgumentException {
        /* 음수 값일 때 등 입력값 예외처리 필요 */
        return Arrays.stream(inputs).mapToInt(NumberValidator::getInteger).toArray();
    }

    private static int getInteger(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }
}
