import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

class Athlete implements Runnable {
    @Getter
    private String name;
    @Getter
    private int distance;
    @Getter
    private int speed;
    @Getter
    private int time;

    public Athlete(String name) {
        this.name = name;
        this.distance = 0;
        this.time = 0;
    }

    @SneakyThrows
    public void run() {
        while (distance < 100 && time < 21) {
                speed = (int) (Math.random() * 5);
                Thread.sleep(1000);
                distance += speed += time;
                System.out.println(name + " has made it " + distance +
                        "km and the speed was " + speed + "km per hour " + time);
                time++;
            }
        }
    }