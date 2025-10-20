package calculator;

import java.util.Arrays;

public class NumberValidator {

    public static int[] parseInt(String[] inputs) throws IllegalArgumentException {
        return Arrays.stream(inputs).mapToInt(NumberValidator::getInteger).toArray();
    }

    private static int getInteger(String input) throws IllegalArgumentException {
        try {
            int parsedInt = Integer.parseInt(input);
            if (parsedInt <= 0) {
                throw new IllegalArgumentException("양수가 아닌 입력값이 들어왔습니다.");
            }
            return parsedInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }
}
