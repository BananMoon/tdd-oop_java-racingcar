package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {
    protected List<Car> cars;
    protected int moveTryCount;
    protected int playCount;
    protected ResultView resultView;
    private static final Random RANDOM = new Random();

    private CarRacing(List<Car> cars, int moveTryCount, int playCount, ResultView resultView) {
        this.cars = cars;
        this.moveTryCount = moveTryCount;
        this.playCount = playCount;
        this.resultView = resultView;
    }

    public static CarRacingBuilder builder() {
        return new CarRacingBuilder();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMoveTryCount() {
        return moveTryCount;
    }

    public int getPlayCount() {
        return playCount;
    }

    public ResultView getResultView() {
        return resultView;
    }

    public void moveCar(Car car, int reference) {
        if (reference >= 4 && reference <= 9) {
            car.move();
        }
    }

    public void start() {
        for (int i = 0; i < this.moveTryCount; i++) {
            this.moveCarsWithRandom();
            this.playCount += 1;
            this.resultView.saveCarsMoveStatus(this.cars);
        }
        this.resultView.printCarRacingResult();
    }

    private void moveCarsWithRandom() {
        for (Car car : this.cars) {
            this.moveCar(car, RANDOM.nextInt(10));
        }
    }


    public static class CarRacingBuilder {
        protected List<Car> cars;
        protected int moveTryCount;
        protected int playCount = 0;
        protected ResultView resultView = new ResultView();


        protected CarRacingBuilder() {
        }

        public CarRacingBuilder cars(int carCount) {
            this.cars = new ArrayList<>(carCount);
            for (int i = 0; i < carCount; i++) {
                cars.add(new Car());
            }
            return this;
        }

        public CarRacingBuilder moveTryCount(int moveTryCount) {
            this.moveTryCount = moveTryCount;
            return this;
        }

        public CarRacing build() {
            return new CarRacing(this.cars, this.moveTryCount, this.playCount, this.resultView);
        }
    }
}
