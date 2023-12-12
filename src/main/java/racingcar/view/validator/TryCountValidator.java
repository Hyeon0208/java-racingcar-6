package racingcar.view.validator;

public class TryCountValidator {

    private TryCountValidator() {
    }

    public static void validate(String input) {
        validateFormat(input);
        validateBlank(input);
    }

    private static void validateFormat(String input) {
        if (!RegexPattern.ONLY_NUMBER.matches(input)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }
}
