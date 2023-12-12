package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.StringConvertor;

public class CarFactory {
    private static final int DEFAULT_POSITION = 0;

    private CarFactory() {
    }

    public static List<Car> generateParticipateCarList(String carNames) {
        String[] cars = StringConvertor.splitByComma(carNames);
        return Arrays.stream(cars)
                .map(name -> new Car(name, DEFAULT_POSITION))
                .collect(Collectors.toList());
    }
}
