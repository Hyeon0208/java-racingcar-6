package racingcar.mock;

import racingcar.domain.NumberGenerator;

public class FakeNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return 5;
    }
}
