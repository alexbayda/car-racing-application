import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
        List<Athlete> athletes = IntStream
                .rangeClosed(1, 10)
                .mapToObj(i -> new Athlete("Athlete " + i))
                .collect(Collectors.toList());
        new Race(athletes).startRace();
    }
}