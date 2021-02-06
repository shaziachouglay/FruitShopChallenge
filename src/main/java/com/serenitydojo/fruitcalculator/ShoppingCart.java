package com.serenitydojo.fruitcalculator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final FruitCatalog fruitCatalog;
    private List<ShopingCartItems> items = new ArrayList<>();

    public ShoppingCart(FruitCatalog fruitCatalog) {
        this.fruitCatalog = fruitCatalog;
    }

    public void add(int quantity, Fruit fruit) {
        double itemCost = quantity * fruitCatalog.costOf(fruit);
        items.add(new ShopingCartItems(fruit.name(),quantity,itemCost));
    }


    public double getTotalPrice() {
        return items.stream().mapToDouble(ShopingCartItems::getItemCost).sum();
    }
}
