package racingcar.view.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import racingcar.util.StringConvertor;

public class CarNameValidator {
    private static final int MAX_NAME_LENGTH = 5;

    private CarNameValidator() {
    }

    public static void validate(String input) {
        validateSeparator(input);
        String[] carNames = StringConvertor.splitByComma(input);
        validateDuplication(carNames);
        validateParticipateCount(carNames);
        for (String carName : carNames) {
            validateNameLength(carName);
            validateBlank(carName);
        }
    }

    private static void validateSeparator(String input) {
        if (!input.contains(StringConvertor.COMMA)) {
            throw new IllegalArgumentException("쉼표로 구분하여 입력해야합니다.");
        }
    }

    private static void validateDuplication(String[] carNames) {
        Set<String> deDuplicatedNames = new HashSet<>(Arrays.asList(carNames));
        if (carNames.length != deDuplicatedNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름을 입력할 수 없습니다.");
        }
    }

    private static void validateParticipateCount(String[] carNames) {
        if (carNames.length < 1) {
            throw new IllegalArgumentException("2대 이상은 참가해야 합니다.");
        }
    }

    private static void validateNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.");
        }
    }


    private static void validateBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 생략할 수 없습니다.");
        }
    }
}
