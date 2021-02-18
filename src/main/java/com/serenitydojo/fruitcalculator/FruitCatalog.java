package com.serenitydojo.fruitcalculator;

import java.util.*;
import java.util.stream.Collectors;

import static com.serenitydojo.fruitcalculator.Fruit.*;

public class FruitCatalog {

    private Map<Fruit,Double> fruitPrices = new HashMap<>();
    public void addFruit(Fruit fruit, double cost) {
        fruitPrices.put(fruit,cost);
    }

    public double costOf(Fruit fruit) {
        if (!fruitPrices.containsKey(fruit)){
            throw new FruitUnavailableException(fruit.name() + "currently unavailable");
        }
        return fruitPrices.get(Apple);
    }

    public List<String> getAvailableFruit() {

        List<String> sortedFruit = new ArrayList<>();
        for (Fruit fruit : fruitPrices.keySet()){
            sortedFruit.add(fruit.name());
        }
        sortedFruit.sort(Comparator.naturalOrder());
        return sortedFruit;
      //return fruitPrices.keySet().stream().map(Enum::name).sorted().collect(Collectors.toList());
    }
}
