import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Race {
    private final List<Athlete> athletes;

    public Race(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    @SneakyThrows
    public void startRace() {
        List<Thread> threads = new ArrayList<>();
        for (Athlete athlete : athletes) {
            Thread thread = new Thread(athlete);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
                thread.join();
        }
        printWinners();
    }

    private void printWinners() {
        System.out.println("The Winners");
        AtomicInteger position = new AtomicInteger(1);
        athletes.stream()
                .sorted(Comparator.comparing(Athlete::getDistance).reversed())
                .limit(3)
                .forEachOrdered(athlete -> {
                    int place = position.getAndIncrement();
                    System.out.println(place + ". " + athlete.getName() +
                            " - Distance: " + athlete.getDistance() + " - Speed: " + athlete.getSpeed());
                });
    }
}