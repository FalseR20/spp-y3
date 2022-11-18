package lab6_1;

public class Program {
    /**
     * <a href="https://refactoring.guru/ru/design-patterns/builder">Builder pattern</a>
     */

    public static void main(String[] args) {
        var orderBuilder = new OrderBuilder().withPacking(PackingType.TAKEAWAY);
        orderBuilder.withBurger(BurgerType.CHICKEN);
        System.out.println(orderBuilder);
        orderBuilder.withBurger(BurgerType.BEEF).withDrink(DrinkType.COLA);
        System.out.println(orderBuilder);
        orderBuilder.withBurger(BurgerType.VEGAN).withDrink(DrinkType.COFFEE);
        System.out.println(orderBuilder);
    }
}
