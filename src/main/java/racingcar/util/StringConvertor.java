package racingcar.util;

public class StringConvertor {
    public static final String COMMA = ",";

    private StringConvertor() {
    }

    public static String[] splitByComma(String value) {
        return value.split(COMMA);
    }
}