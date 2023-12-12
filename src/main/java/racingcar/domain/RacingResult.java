package racingcar.domain;

import java.util.List;

public class RacingResult {
    private final RacingCars racingCars;

    public RacingResult(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public List<String> findWinners() {
        return racingCars.findHead();
    }
}
