package lab3_2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class Stock {
    public ArrayList<Product> products;

    Stock(Product... products) {
        this.products = new ArrayList<>(Arrays.asList(products));
    }

    @SuppressWarnings("unchecked")
    Stock(@NotNull ArrayList<Product> products) {
        this.products = (ArrayList<Product>) products.clone();
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", this.getClass().getSimpleName(), products.toString());
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public Stock clone() {
        return new Stock(products);
    }

    public void add(Product product) {
        products.add(product);
    }

    public void remove(Product product) {
        products.remove(product);
    }

    public Stock filterByName(String name) {
        var pr = new Stock();
        for (var product : products)
            if (product.name.equals(name)) pr.add(product);
        return pr;
    }

    public Stock filterByNamePrice(String name, float price) {
        var pr = new Stock();
        for (var product : products)
            if (product.name.equals(name) && product.price <= price) pr.add(product);
        return pr;
    }

    public Stock filterByNotExpired() {
        var pr = this.clone();
        for (var product : products)
            if (product.is_expired()) pr.remove(product);
        return pr;
    }
}
