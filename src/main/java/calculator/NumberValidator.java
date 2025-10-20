package calculator;

import java.util.Arrays;

public class NumberValidator {

    public static int[] parseInt(String[] inputs) {
        /* 음수 값일 때 등 입력값 예외처리 필요 */
        return Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
    }
}
