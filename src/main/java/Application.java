import java.util.ArrayList;

public class Application {

    static ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++){
            cars.add(new Car("Car " + i, 0));
        }
        Race race = new Race(cars);
        race.startRace();
    }



}
