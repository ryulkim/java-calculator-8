package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {
    @Test
    void 정상_입력_숫자로_바꿀_수_있는_경우() {
        // given
        String[] inputs = {"1", "2", "3", "4"};

        // when
        int[] result = NumberValidator.parseInt(inputs);

        // then
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    void 예외_처리_문자가_입력된_경우() {
        // given
        String[] inputs = {"1", "a", "3", "4"};

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumberValidator.parseInt(inputs));
    }

    @Test
    void 예외_처리_양수가_아닌_수가_입력된_경우() {
        // given
        String[] inputs = {"1", "-2", "3", "4"};

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumberValidator.parseInt(inputs));
    }
}
