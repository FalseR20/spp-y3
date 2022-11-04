package lab5_2;

public class Bicycle extends Transport {
    private final String name;
    private final double speed;
    private final double cargoCoefficient;
    private final double personCoefficient;

    public Bicycle(String name, double speed) {
        this.name = name;
        this.speed = speed;
        this.cargoCoefficient = 0.75;
        this.personCoefficient = 0.5;
    }

    @Override
    public void honk() {
        System.out.println("Ding-ding!");
    }

    @Override
    public double calculateRideTime(double distance) {
        if (distance > 50)
            System.out.println(distance + " km? Are you on beer?");
        return distance / this.speed;
    }

    @Override
    public double calculateRideCost(double distance) {
        return distance * personCoefficient;
    }

    @Override
    public double calculateLoadCost(double distance) {
        return distance * cargoCoefficient;
    }

    @Override
    public String toString() {
        return "Bicycle{" + "name='" + name + '\'' + '}';
    }
}
