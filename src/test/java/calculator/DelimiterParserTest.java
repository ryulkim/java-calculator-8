package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DelimiterParserTest {

    @Test
    public void 정상_입력_구분자_쉼표로만_된_경우() {
        // given
        String input = "1,2,3";

        // when
        int[] result = DelimiterParser.getNumbersByDelimiter(input);

        // then
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    public void 정상_입력_구분자_콜론으로만_된_경우() {
        // given
        String input = "1:2:3";

        // when
        int[] result = DelimiterParser.getNumbersByDelimiter(input);

        // then
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, result);
    }
}
