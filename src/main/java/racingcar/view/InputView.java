package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.validator.CarNameValidator;
import racingcar.view.validator.TryCountValidator;

public class InputView {

    public String inputCarNames() {
        String carNames = Console.readLine();
        CarNameValidator.validate(carNames);
        return carNames;
    }

    public String inputTryCount() {
        String tryCount = Console.readLine();
        TryCountValidator.validate(tryCount);
        return tryCount;
    }
}
