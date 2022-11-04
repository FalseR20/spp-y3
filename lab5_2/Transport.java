package lab5_2;

public abstract class Transport {
    void ride() {
        System.out.println("Let's go!");
    }

    public abstract void honk();

    abstract double calculateRideTime(double distance);

    abstract double calculateRideCost(double distance);

    abstract double calculateLoadCost(double distance);
}
