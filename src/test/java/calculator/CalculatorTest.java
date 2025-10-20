package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void 정상_입력_더하기() {
        int[] inputs = {1, 2, 3, 10, 11};
        int result = Calculator.add(inputs);
        Assertions.assertEquals(result, 27);
    }
}
