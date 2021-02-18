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
        List<Double> itemPrices = new ArrayList<>();
        for (ShopingCartItems item : items){
            itemPrices.add(item.getItemCost());
        }
        double sum = 0.0;
        for (double itemCost : itemPrices){
            sum = sum +itemCost;
        }
        //using java 8 the below method
        //return items.stream().mapToDouble(ShopingCartItems::getItemCost).sum();
        return sum;
    }
}
