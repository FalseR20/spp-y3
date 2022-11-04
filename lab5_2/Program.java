package lab5_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        ArrayList<Transport> transports = new ArrayList<>(
                Arrays.asList(
                        new Car("Skoda", 70),
                        new Bicycle("Aist", 15),
                        new Wagon("From grandpa", 5)
                )
        );
        int distance = 100;
        for (Transport transport : transports) {
            System.out.println("\nTransport: " + transport);
            System.out.print("Honk: ");
            transport.honk();
            System.out.println("Distance: " + distance + " kms");
            System.out.println("Time: " + transport.calculateRideTime(distance) + " hours");
            System.out.println("Cost for person: $" + transport.calculateRideCost(distance));
            System.out.println("Cost for things: $" + transport.calculateLoadCost(distance));
            transport.ride();
        }
    }
}
