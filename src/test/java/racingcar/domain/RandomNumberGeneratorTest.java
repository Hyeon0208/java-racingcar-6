package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @DisplayName("0 ~ 9 범위의 숫자만을 생성한다.")
    @RepeatedTest(1000)
    void generate() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        int number = numberGenerator.generate();

        assertThat(number)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}