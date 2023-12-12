package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.mock.FakeNumberGenerator;

class RacingCarsTest {
    Car pony;
    Car zon;
    RacingCars racingCars;

    @BeforeEach
    void init() {
        pony = new Car("pony", 2);
        zon = new Car("zon", 5);
        racingCars = new RacingCars(List.of(pony, zon));
    }

    @DisplayName("경주 자동차들이 한 칸식 이동한다.")
    @Test
    void move() {
        racingCars.move(new FakeNumberGenerator());

        List<Car> cars = racingCars.getCars();
        int ponyPosition = pony.getPosition();
        int zonPosition = zon.getPosition();

        assertThat(ponyPosition).isEqualTo(3);
        assertThat(zonPosition).isEqualTo(6);
    }

    @DisplayName("최종 우승자는 5번 이동한 zon이다.")
    @Test
    void findHead() {
        List<String> head = racingCars.findHead();

        assertThat(head)
                .containsExactly(zon.getName());
    }

    @DisplayName("가장 많이 이동한 거리는 5이다.")
    @Test
    void getMaxPosition() {
        int maxPosition = racingCars.getMaxPosition();

        assertThat(maxPosition).isEqualTo(5);
    }
}