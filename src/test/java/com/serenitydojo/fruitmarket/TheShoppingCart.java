package com.serenitydojo.fruitmarket;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.serenitydojo.fruitmarket.Fruit.*;
import static com.serenitydojo.fruitmarket.Fruit.Pear;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TheShoppingCart {
    Catalog catalog;
    ShoppingCart cart;

    @Before
    public void createANewCatalog(){
        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00)
                .setPriceOf(Orange).to(5.50)
                .setPriceOf(Banana).to(4.50)
                .setPriceOf(Pear).to(4.50);
        List<ShoppingCartItems> items = new ArrayList<>();
        cart = new ShoppingCart(catalog, items);
    }
    @Test
    public void shouldStartWithNoItems(){
        assertThat(cart.getItems()).isEmpty();
    }
    @Test
    public void shouldKeepTrackOfItemsAddedToTheCart() {
        cart.add(2.0).kilosOf(Apple)
                .add(3.0).kilosOf(Orange);

        Assertions.assertThat(cart.getItems()).hasSize(2);
    }
    @Test
    public void shouldUseTheCatalogToCalculateThePriceOfItemsAddedToTheCart() {
        cart.add(2.0).kilosOf(Apple)
                .add(2.0).kilosOf(Orange)
                .add(1.0).kilosOf(Pear);

        Assertions.assertThat(cart.getTotalPrice()).isEqualTo(23.50);
    }
    @Test
    public void shouldGiveBulkDiscountsDiscount() {
        cart.add(10.0).kilosOf(Apple);

        Assertions.assertThat(cart.getTotalPrice()).isEqualTo(36.00);
    }
    @Test
    public void buildDiscountsOnlyApplyToQuantitiesOverFiveKgs() {
        cart.add(10.0).kilosOf(Apple);
        cart.add(2.00).kilosOf(Orange);

        Assertions.assertThat(cart.getTotalPrice()).isEqualTo(47.00);
    }
}
