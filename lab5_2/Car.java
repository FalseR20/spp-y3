package lab5_2;

public class Car extends Transport {
    private final String name;
    private final double speed;
    private final double cargoCoefficient;
    private final double personCoefficient;

    public Car(String name, double speed) {
        this.name = name;
        this.speed = speed;
        this.cargoCoefficient = 2.5;
        this.personCoefficient = 1.75;
    }

    @Override
    public void honk() {
        System.out.println("Beep-beep!");
    }

    @Override
    public double calculateRideTime(double distance) {
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
        return "Car{" + "name='" + name + '\'' + '}';
    }
}
