package lab4_1;

public class Program {
    static public void main(String[] args) {
        var myMoney = 330F;
        var iphone14ProModel = new Mobile.Model("Apple iPhone 14 Pro 128GB black", 1099.00F);
        var mobilka = new Mobile.Model("Xiaomi bebra note cum", 300F);
        var dreamPhone = new Mobile(iphone14ProModel, "FalseR");
        System.out.printf("Phone of the dream: %s\n", dreamPhone);
        System.out.println(
                dreamPhone.model.canIBuy(myMoney)
                        ? "That's my boy"
                        : mobilka.canIBuy(myMoney)
                                ? String.format("Heh, there is something for you: %s", mobilka)
                                : "Go work, bastard!"
        );
    }
}
