package com.serenitydojo.fruitmarket;

import com.serenitydojo.fruitcalculator.FruitUnavailableException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalog {
    private Map<Fruit,Double> pricePerKilo = new HashMap<>();
    public CatalogBuilder setPriceOf(Fruit fruit) {
        return new CatalogBuilder(this,fruit);
    }

    public Double getPriceOf(Fruit fruit) {
        if (pricePerKilo.containsKey(fruit)){
            return pricePerKilo.get(fruit);
        }
        throw new FruitUnavailableException(fruit.name() + " is currently unavailable");
    }

    public List<String> getAvailableFruit() {
        return pricePerKilo.keySet().stream()
                .map(Enum::name).sorted()
                .collect(Collectors.toList());
    }

    public static class CatalogBuilder {
        private Catalog catalog;
        private Fruit fruit;

        public CatalogBuilder(Catalog catalog, Fruit fruit) {
            this.catalog = catalog;
            this.fruit = fruit;
        }

        public Catalog to(double price) {
           catalog.pricePerKilo.put(fruit,price);
           return catalog;
        }
    }
}
