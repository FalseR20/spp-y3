package lab4_2;

public class Program {
    public static void main(String[] args) {
        var wheels = new Wheel[]{new Wheel(), new Wheel(), new Wheel(), new Wheel()};
        {
            var car = new Car(wheels);
            System.out.printf("Car is broken: %s\n", car.isBroken());
            wheels[2].pierce();
            System.out.printf("Car is broken: %s\n", car.isBroken());
        }

        {
            wheels[2].fix();
            var newCar = new Car(wheels);
            System.out.printf("New car is broken: %s\n", newCar.isBroken());
        }
    }
}
