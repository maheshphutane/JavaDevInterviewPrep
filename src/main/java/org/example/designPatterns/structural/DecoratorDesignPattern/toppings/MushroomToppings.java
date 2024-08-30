package org.example.designPatterns.structural.DecoratorDesignPattern.toppings;

import org.example.designPatterns.structural.DecoratorDesignPattern.BasePizza;

public class MushroomToppings extends PizzaToppings{
    BasePizza basePizza;
    public MushroomToppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 50;
    }

}
