package lab3_2;

public class Program {
    static public void main(String[] args) {
        var stock = new Stock(
                new Product(1, "Cheese", 1, "Lay's", 5.56F, 12),
                new Product(2, "Cheese", 2, "Omega", 3.12F, 6),
                new Product(3, "Cheese", 3, "Flint", 1.49F, 0, -10),
                new Product(4, "Parer", 4, "Lay's", 5.56F, 0, 12)
        );
        System.out.println(stock);
        System.out.println(stock.filterByName("Cheese"));
        System.out.println(stock.filterByNamePrice("Cheese", 4F));
        System.out.println(stock.filterByNotExpired());
    }
}

