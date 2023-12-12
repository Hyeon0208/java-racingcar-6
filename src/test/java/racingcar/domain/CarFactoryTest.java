package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarFactoryTest {

    @DisplayName("쉼표로 구분딘 문자열을 쉼표로 구분하여 List<Car>로 반환한다")
    @Test
    void generateParticipateCarList() {
        String input = "pobi,woni,jun";

        List<Car> cars = CarFactory.generateParticipateCarList(input);

        assertThat(cars)
                .containsExactly(new Car("pobi", 0),
                        new Car("woni", 0),
                        new Car("jun", 0));
    }
}