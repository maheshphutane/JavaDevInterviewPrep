package org.example.MachineCoding.SnakeAndLadder;

import java.util.*;

public class StartGame {
    public static void main(String[] args) {
        Player p1 = new Player("Mahesh");
        Player p2 = new Player("Pankaj");
        Map<Integer,Integer> snakes = new HashMap<>();
        Map<Integer,Integer> ladders = new HashMap<>();
        Map<String,Integer> playerPos = new HashMap<>();
        Dice dice = new Dice(2);

        Queue<Player> playerQueue = new LinkedList<>();

        playerQueue.add(p1);
        playerQueue.add(p2);

        snakes.put(45,34);
        snakes.put(75,9);
        snakes.put(10,2);
        snakes.put(14,4);
        snakes.put(99,50);

        ladders.put(8,27);
        ladders.put(56,80);
        ladders.put(37,90);
        ladders.put(38,80);
        ladders.put(16,60);
        ladders.put(4,70);

        playerPos.put(p1.getPlayerName(),1);
        playerPos.put(p2.getPlayerName(),1);

        GameBoard gb = new GameBoard(playerQueue,snakes,ladders,playerPos,100,dice);
        gb.startGame();
    }
}
