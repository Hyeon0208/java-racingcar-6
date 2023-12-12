package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingCars {
    private static final int MIN_MOVE_CONDITION = 4;
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(NumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            if (randomNumberGenerator.generate() >= MIN_MOVE_CONDITION) {
                car.move();
            }
        }
    }

    public List<String> findHead() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .toList();
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
