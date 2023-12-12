package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingResult;

public class OutputView {
    private static final String MOVE_EXPRESS = "-";
    private static final String JOIN_SEPARATOR = ", ";

    public void printRacingCarNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printExecutionResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacingProgress(List<Car> cars) {
        String racingProgress = cars.stream()
                .map(car -> String.format("%s : %s\n", car.getName(), MOVE_EXPRESS.repeat(car.getPosition())))
                .collect(Collectors.joining());
        System.out.println(racingProgress);
    }

    public void printFinalWinner(RacingResult racingResult) {
        System.out.printf("최종 우승자 : %s", String.join(JOIN_SEPARATOR, racingResult.findWinners()));
    }
}
