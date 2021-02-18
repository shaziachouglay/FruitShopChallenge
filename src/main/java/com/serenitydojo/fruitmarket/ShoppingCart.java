package com.serenitydojo.fruitmarket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final Catalog catalog;
    private final List<ShoppingCartItems> items;

    public ShoppingCart(Catalog catalog, List<ShoppingCartItems> items) {
        this.catalog = catalog;
        this.items = items;
    }

    public List<ShoppingCartItems> getItems() {
        return new ArrayList<>(items);
    }

    public ShoppingCartAdder add(double amount) {
        return new ShoppingCartAdder(this,amount);
    }

    public Double getTotalPrice() {
        return items.stream().mapToDouble(item-> item.getTotalCost()).sum();
    }

    public static class ShoppingCartAdder {
        private final ShoppingCart shoppingCart;
        private final double amount;

        public ShoppingCartAdder(ShoppingCart shoppingCart, double amount) {
            this.shoppingCart = shoppingCart;
            this.amount = amount;
        }

        public ShoppingCart kilosOf(Fruit fruit) {
            double basePrice = shoppingCart.catalog.getPriceOf(fruit);
            double discountedPrice = (amount >= 5)? basePrice * 0.9 : basePrice;
            ShoppingCartItems item = new ShoppingCartItems(fruit,amount,discountedPrice * amount);
            shoppingCart.items.add(item);
            return shoppingCart;
        }
    }
}
