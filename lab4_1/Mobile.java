package lab4_1;

public class Mobile {
    static class Model {
        public String name;
        public float price;

        Model(String name, float price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("%s for %s", name, price == 300F ? "300 bucks" : String.format("%.2f USD", price));
        }

        public boolean canIBuy(float money) {
            return money >= price;
        }
    }

    public Model model;
    public String owner;

    Mobile(Model model, String owner) {
        this.model = model;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("%s's %s)", owner, model);
    }
}
