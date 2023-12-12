package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차가 한칸 전진한다.")
    @Test
    void move() {
        Car car = new Car("pobi", 0);
        car.move();

        int position = car.getPosition();

        assertThat(position).isEqualTo(1);
    }
}