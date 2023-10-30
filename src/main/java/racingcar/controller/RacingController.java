package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingResult;
import racingcar.util.Convertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void startGame() {
        RacingCars racingCars = getParticipationCars();
        int tryCount = getTryCount();
        racing(racingCars, tryCount);
    }

    private RacingCars getParticipationCars() {
        OutputView.printCarNameInputMessage();
        String carNames = InputView.inputCarNames();
        return new RacingCars(CarFactory.generateParticipationCarList(carNames));
    }

    private int getTryCount() {
        OutputView.printTryCountInputMessage();
        return Convertor.convertStringToInt(InputView.inputTryCount());
    }

    private void racing(RacingCars racingCars, int tryCount) {
        OutputView.printExecutionResultMessage();
        RacingResult racingResult = racingCars.createRacingResult();
        while (isNotRacingFinished(tryCount)) {
            racingCars.move();
            racingResult = racingCars.createRacingResult();
            OutputView.printResult(racingResult.getCarStatuses());
            tryCount--;
        }
        OutputView.printWinner(racingResult.findWinner());
    }

    private boolean isNotRacingFinished(int tryCount) {
        return tryCount > 0;
    }
}
