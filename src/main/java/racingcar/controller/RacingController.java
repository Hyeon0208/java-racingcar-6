package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingResult;
import racingcar.view.OutputView;
import racingcar.view.handler.InputHandler;

public class RacingController {
    private final NumberGenerator numberGenerator;
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public RacingController(NumberGenerator numberGenerator, InputHandler inputHandler, OutputView outputView) {
        this.numberGenerator = numberGenerator;
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printRacingCarNamesInputMessage();
        String carNames = inputHandler.receiveValidatedCarNames();
        outputView.printTryCountInputMessage();
        int tryCount = inputHandler.receiveValidatedTryCount();
        RacingCars racingCars = new RacingCars(CarFactory.generateParticipateCarList(carNames));
        racing(racingCars, tryCount);
        showWinner(racingCars);
    }

    public void racing(RacingCars racingCars, int tryCount) {
        outputView.printExecutionResultMessage();
        while (tryCount > 0) {
            racingCars.move(numberGenerator);
            outputView.printRacingProgress(racingCars.getCars());
            tryCount--;
        }
    }

    public void showWinner(RacingCars racingCars) {
        RacingResult racingResult = new RacingResult(racingCars);
        outputView.printFinalWinner(racingResult);
    }
}
