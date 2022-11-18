package lab6_1;

import java.util.ArrayList;

public class OrderBuilder {
    private final ArrayList<BurgerType> burgers;
    private final ArrayList<DrinkType> drinks;
    private PackingType packing;
    private Double totalCost;

    public OrderBuilder() {
        this.burgers = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.totalCost = 0.00;
    }

    public ArrayList<BurgerType> getBurgers() {
        return burgers;
    }

    public ArrayList<DrinkType> getDrinks() {
        return drinks;
    }

    public PackingType getPacking() {
        return packing;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public OrderBuilder withBurger(BurgerType burger) {
        burgers.add(burger);
        totalCost += burger.getPrice();
        return this;
    }

    public OrderBuilder withDrink(DrinkType drink) {
        drinks.add(drink);
        totalCost += drink.getPrice();
        return this;
    }

    public OrderBuilder withPacking(PackingType packing) {
        this.packing = packing;
        totalCost += packing.getPrice();
        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "Task1.Order{burgers=%s, drinks=%s, packing=%s, totalCost=%s}", burgers, drinks, packing, totalCost
        );
    }
}
