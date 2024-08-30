package org.example.designPatterns.structural.DecoratorDesignPattern.toppings;

import org.example.designPatterns.structural.DecoratorDesignPattern.BasePizza;

public class PannerToppings extends PizzaToppings{
    BasePizza basePizza;
    public PannerToppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 60;
    }
}
