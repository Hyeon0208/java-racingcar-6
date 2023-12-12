package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.validator.CarNameValidator;

public class InputView {

    public String inputCarNames() {
        String carNames = Console.readLine();
        CarNameValidator.validate(carNames);
        return carNames;
    }
}
