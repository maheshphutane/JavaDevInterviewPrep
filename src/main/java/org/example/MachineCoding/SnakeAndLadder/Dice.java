package org.example.MachineCoding.SnakeAndLadder;

import lombok.Getter;

@Getter
public class Dice {
    private int noOfDice;
    public Dice(int noOfDice){
        this.noOfDice = noOfDice;
    }
    public int rollDice() throws InterruptedException {
        Thread.sleep(1000);
        return (int)(Math.random() * (6*noOfDice - 1*noOfDice + 1)) + noOfDice;
    }
}
