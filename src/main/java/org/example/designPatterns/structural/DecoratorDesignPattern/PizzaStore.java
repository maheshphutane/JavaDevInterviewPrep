package org.example.designPatterns.structural.DecoratorDesignPattern;

import org.example.designPatterns.structural.DecoratorDesignPattern.toppings.CapsicumToppings;
import org.example.designPatterns.structural.DecoratorDesignPattern.toppings.MushroomToppings;
import org.example.designPatterns.structural.DecoratorDesignPattern.toppings.PannerToppings;

public class PizzaStore {
    public static void main(String[] args) {
        BasePizza pizza = new PannerToppings(new CapsicumToppings(new Margherita()));
        System.out.println("Cost of Pizza: "+pizza.cost());

        pizza = new MushroomToppings(new VegDelight());
        System.out.println("Cost of Pizza: "+pizza.cost());
    }
}
