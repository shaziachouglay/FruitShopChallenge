package com.serenitydojo.fruitcalculator;

public class ShopingCartItems {
    public ShopingCartItems(String item, int quantity, double itemCost) {
        this.item = item;
        this.quantity = quantity;
        this.itemCost = itemCost;
    }

    public String getItem() {
        return item;
    }

    public double getQuantity() {
        return quantity;
    }

    private String item;
    private int quantity;

    public double getItemCost() {
        return itemCost;
    }

    private double itemCost;
}
