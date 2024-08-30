package org.example.designPatterns.structural.DecoratorDesignPattern.toppings;

import org.example.designPatterns.structural.DecoratorDesignPattern.BasePizza;

public class CapsicumToppings extends PizzaToppings {
    BasePizza basePizza;
    public CapsicumToppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 30;
    }
}
