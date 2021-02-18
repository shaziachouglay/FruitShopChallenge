package com.serenitydojo.fruitmarket;

public class ShoppingCartItems {
    private Fruit fruit;
    private Double quantity;

    public Fruit getFruit() {
        return fruit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    private Double totalCost;

    public ShoppingCartItems(Fruit fruit, Double quantity, Double totalCost) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }
}
