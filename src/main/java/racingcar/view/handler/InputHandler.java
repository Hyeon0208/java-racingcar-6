package racingcar.view.handler;

import java.util.function.Supplier;
import racingcar.util.StringConvertor;
import racingcar.view.ErrorView;
import racingcar.view.InputView;

public class InputHandler {
    private final InputView inputView;
    private final ErrorView errorView;

    public InputHandler(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
    }

    public String receiveValidatedCarNames() {
        return receiveValidatedInput(inputView::inputCarNames);
    }

    public int receiveValidatedTryCount() {
        String tryCount = receiveValidatedInput(inputView::inputTryCount);
        return StringConvertor.convertToInt(tryCount);
    }

    private <T> T receiveValidatedInput(Supplier<T> inputView) {
        while (true) {
            try {
                return inputView.get();
            } catch (IllegalArgumentException exception) {
                errorView.printErrorMessage(exception.getMessage());
            }
        }
    }
}