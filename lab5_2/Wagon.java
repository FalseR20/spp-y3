package lab5_2;

public class Wagon extends Transport {

    private final String name;
    private final double speed;
    private final double cargoCoefficient;
    private final double personCoefficient;

    public Wagon(String name, double speed) {
        this.name = name;
        this.speed = speed;
        this.cargoCoefficient = 1.25;
        this.personCoefficient = 0.75;
    }

    @Override
    public void honk() {
        System.out.println("Cap-cap!");
    }

    @Override
    public double calculateRideTime(double distance) {
        if (distance > 50)
            System.out.println("Madman...");
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
        return "Wagon{" + "name='" + name + "'}";
    }
}
