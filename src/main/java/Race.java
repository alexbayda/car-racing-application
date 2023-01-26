import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Race {
    private final ArrayList<Car> cars;
    private final ExecutorService executor;

    public Race(ArrayList<Car> cars) {
        this.cars = cars;
        executor = Executors.newFixedThreadPool(10);
    }

    public void startRace() {
        for (Car car : cars) {
            executor.execute(car);
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdownNow();
    }
}
