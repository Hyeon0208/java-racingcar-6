package racingcar.view.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountValidatorTest {

    @DisplayName("숫자가 아닌 값을 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "일"})
    void validateFormat(String input) {
        assertThatThrownBy(() -> TryCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("아무 값을 입력하지 않을 경우 예외가 발생한다.")
    @Test
    void validateBlank() {
        String input = "";

        assertThatThrownBy(() -> TryCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}