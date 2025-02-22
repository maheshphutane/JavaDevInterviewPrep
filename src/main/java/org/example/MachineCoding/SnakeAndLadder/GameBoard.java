package org.example.MachineCoding.SnakeAndLadder;


import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Queue;

@AllArgsConstructor
public class GameBoard {
    private Queue<Player> playerQueue;
    private Map<Integer,Integer> snakes;
    private Map<Integer,Integer> ladders;
    private Map<String,Integer> playerPosition;
    private int boardSize;
    private Dice dice;

    public void startGame(){
        int rank = 1;
        System.out.println("**********************************");
        System.out.println("*     Welcome to Snake & Ladder  *");
        System.out.println("**********************************");
        System.out.println("Total Player "+playerQueue.size());
        while (!playerQueue.isEmpty()){
            Player currentPlayer = playerQueue.poll();
            String currPlayerName = currentPlayer.getPlayerName();
            int currPlayerPos = playerPosition.get(currPlayerName);
            System.out.println(currPlayerName+" is at position "+currPlayerPos);
            int newPos = 0;
            try {
                newPos = currPlayerPos+dice.rollDice();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(currPlayerName+" Rolled Dice to : " + (newPos-currPlayerPos));
            if(newPos > boardSize){
                playerQueue.offer(currentPlayer);
                continue;
            }
            boolean isSnakeOrLadder = false;
            if(snakes.containsKey(newPos)){
                int oldPos = newPos;
                newPos = snakes.get(newPos);
                isSnakeOrLadder = true;
                System.out.println(currPlayerName+" is Bitten by Snake from "+oldPos+" to "+newPos);
            }else if(ladders.containsKey(newPos)){
                newPos = ladders.get(newPos);
                isSnakeOrLadder = true;
                System.out.println(currPlayerName+" Got Ladder from "+currPlayerPos+" to "+newPos);
            }
            if(newPos == boardSize){
                System.out.println(currPlayerName+" Won with "+rank+" position!!!");
                rank++;
                continue;
            }
            if(newPos==boardSize-dice.getNoOfDice()+1){
                System.out.println(currPlayerName+" is Lost");
                continue;
            }
            playerPosition.put(currPlayerName,newPos);
            playerQueue.offer(currentPlayer);
        }
    }
}
