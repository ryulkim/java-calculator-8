package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void 정상_입력_더하기() {
        // given
        int[] inputs = {1, 2, 3, 10, 11};

        // when
        int result = Calculator.add(inputs);

        // then
        Assertions.assertEquals(result, 27);
    }
}
