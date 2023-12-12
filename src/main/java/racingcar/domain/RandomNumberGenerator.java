package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }
}
