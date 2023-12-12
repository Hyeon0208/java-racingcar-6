package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.ErrorView;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.handler.InputHandler;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        InputHandler inputHandler = initHandler();
        OutputView outputView = new OutputView();
        RacingController controller = new RacingController(numberGenerator, inputHandler, outputView);
        controller.start();
    }

    private static InputHandler initHandler() {
        InputView inputView = new InputView();
        ErrorView errorView = new ErrorView();
        return new InputHandler(inputView, errorView);
    }
}
