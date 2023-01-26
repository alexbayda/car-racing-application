public class Car extends Thread {

    String name;
    int distance;
    int speed;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    // run creates random car movement during race, uses random to generate random speed each second
    public void run() {
        while (distance < 100) {
            try {
                speed = (int) (Math.random() * 10);
                Thread.sleep(1000);
                distance += speed;
                System.out.println(name + " has made it " + distance +
                        " and its speed was " + speed +
                        "km per hour, wow that's quick");
                winners();

            } catch (InterruptedException e) {
                break;
            }
        }
        if (distance < 100)
            System.out.println(name + " unfortunately did not make it :(");
        else
            System.out.println(name + "has finished the race! Woohoo");
    }

    //sorts cars by distance they drove and prints the winners + checks the cars that did not make it to the finish
    public void winners() {

        Application.cars.sort((Car c1, Car c2) -> c2.distance - c1.distance);
        System.out.println("The Winners");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". "
                    + Application.cars.get(i).name + " - Distance: "
                    + Application.cars.get(i).distance + " - Speed: "
                    + Application.cars.get(i).speed);
        }
    }
}