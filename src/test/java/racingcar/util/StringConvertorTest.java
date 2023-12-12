package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringConvertorTest {

    @DisplayName("쉼표로 구분된 문자열을 쉼표로 구분하여 배열을 반환한다.")
    @Test
    void splitByComma() {
        String input = "pobi,woni,jun";

        String[] carNames = StringConvertor.splitByComma(input);
        String[] expected = new String[]{"pobi", "woni", "jun"};

        assertThat(carNames).isEqualTo(expected);
    }

    @DisplayName("숫자 문자열을 정수로 변환한다.")
    @Test
    void convertToInt() {
        String input = "5";

        int number = StringConvertor.convertToInt(input);
        int expected = 5;

        assertThat(number).isEqualTo(expected);
    }
}