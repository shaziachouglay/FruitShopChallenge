package com.serenitydojo.fruitcalculator;

import org.assertj.core.error.ShouldBeUpperCase;
import org.junit.Before;
import org.junit.Test;

import static com.serenitydojo.fruitcalculator.Fruit.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
 /*
 The shop sells apples, oranges, bananas, pears, peaches and other fruit, depending on availability. For example the prices per kilo for the currently available fruit are:
Apples: $4.00
Oranges: $5.50
Bananas: $6.00
Pears: $4.50
You can update the catalog with the current market price of a fruit
The Catalog should list the names of the currently available fruit in alphabetical order
The Catalog should report the price of a given type of fruit
The Catalog should throw a FruitUnavailableException if the fruit is not currently available
You can add items to your shopping cart, which should keep a running total.
When you buy 5 kilos or more of any fruit, you get a 10% discount.

  */

public class WhenAddingFruitToTheCatalog {
    FruitCatalog fruitCatalog;
    @Before
    public void createCatalog(){
        fruitCatalog = new FruitCatalog();
    }

    @Test
    public void the_catalog_contains_the_fruit_currently_for_sale(){

        fruitCatalog.addFruit(Apple,4.00);

        //Given apples cost 4.00
        //When I get the price of an apple
        //Then it shd be $4.00
        double price = fruitCatalog.costOf(Apple);
        assertThat(price).isEqualTo(4.00);

    }
    @Test
    public void the_catalog_shd_list_fruit_in_alphabetical_order(){

        fruitCatalog.addFruit(Orange,5.50);
        fruitCatalog.addFruit(Banana,6.00);
        fruitCatalog.addFruit(Pear,4.50);
        fruitCatalog.addFruit(Apple,4.00);

        assertThat(fruitCatalog.getAvailableFruit()).containsExactly("Apple","Banana","Orange","Pear");
    }

    @Test(expected = FruitUnavailableException.class )
    public void shd_throw_fruit_unavailable_exception_if_fruit_is_unavailable(){
        fruitCatalog.addFruit(Orange,5.50);
        fruitCatalog.costOf(Apple);
    }

    @Test
    public void shd_keep_running_total_of_items_in_the_cart(){
        fruitCatalog.addFruit(Apple,3.00);
        fruitCatalog.addFruit(Orange,4.00);
        ShoppingCart cart = new ShoppingCart(fruitCatalog);
        cart.add(1,Apple);
        cart.add(2,Orange);

        assertThat(cart.getTotalPrice()).isEqualTo(11.0);

    }

}
