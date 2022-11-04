package lab5_1;

public class Program {

    public static void main(String[] args) {
        var cargoShip = new CargoShip();
        System.out.println("Cargo ship class: ");
        cargoShip.swim();
        cargoShip.load();
        cargoShip.weight();
        cargoShip.passengers();
        Tanker tankerTwo = new Tanker();
        System.out.println("Tanker class: ");
        tankerTwo.swim();
        tankerTwo.load();
        tankerTwo.typeOfGoods();
        tankerTwo.weight();
        tankerTwo.passengers();
    }
}
