package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DelimiterParserTest {

    @Test
    void 정상_입력_구분자_쉼표로만_된_경우() {
        // given
        String input = "1,2,3";

        // when
        int[] result = DelimiterParser.getNumbersByDelimiter(input);

        // then
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void 정상_입력_구분자_콜론으로만_된_경우() {
        // given
        String input = "1:2:3";

        // when
        int[] result = DelimiterParser.getNumbersByDelimiter(input);

        // then
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void 정상_입력_쉼표와_콜론_모두_구성된_경우() {
        // given
        String input = "1:2,3";

        // when
        int[] result = DelimiterParser.getNumbersByDelimiter(input);

        // then
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void 정상_입력_커스텀_구분자_길이가_1로_구성된_경우() {
        // given
        String input = "//;\n1;2;3";

        // when
        int[] result = DelimiterParser.getNumbersByDelimiter(input);

        // then
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void 정상_입력_커스텀_구분자_길이가_2이상으로_구성된_경우() {
        // given
        String input = "//;;;\n1;;;2;;;3";

        // when
        int[] result = DelimiterParser.getNumbersByDelimiter(input);

        // then
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void 정상_입력_커스텀_구분자와_기본_구분자가_혼용_구성된_경우() {
        // given
        String input = "//;;;\n1:2;;;3,4";

        // when
        int[] result = DelimiterParser.getNumbersByDelimiter(input);

        // then
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    void 정상_입력_커스텀_구분자가_특수_문자일_경우() {
        String input = "//.\n1.2.3.4";

        // when
        int[] result = DelimiterParser.getNumbersByDelimiter(input);

        // then
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    void 예외_처리_커스텀_구분자에_숫자가_포함되어있는_경우() {
        // given
        String input = "//a11a\n1,2,3,4";

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> DelimiterParser.getNumbersByDelimiter(input));
    }

    @Test
    void 예외_처리_문자가_입력된_경우() {
        // given
        String input = "//;\n1a;2;3;4";

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> DelimiterParser.getNumbersByDelimiter(input));
    }

    @Test
    void 예외_처리_양수가_아닌_수가_입력된_경우() {
        // given
        String input = "//;\n1;-2;3;4";

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> DelimiterParser.getNumbersByDelimiter(input));
    }
}
