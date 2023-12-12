package racingcar.view.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    @DisplayName("자동차 이름들을 쉼표로 구분하지 않을 경우 예외가 발생한다.")
    @Test
    void validateSeparator() {
        String input = "pobi-joon-hong";

        assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 이름을 입력할 경우 예외가 발생한다.")
    @Test
    void validateDuplication() {
        String input = "pobi,pobi,joon";

        assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가 자동차가 2대 미만 일 경우 예외가 밟생한다.")
    @Test
    void validateParticipateCount() {
        String input = "pobi";

        assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 5글자를 초과할 경우 예외가 발생한다.")
    @Test
    void validateNameLength() {
        String input = "asdfgz,jon";

        assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름에 공백을 사용할 경우 예외가 발생한다.")
    @Test
    void validateBlank() {
        String input = ",,,";

        assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}