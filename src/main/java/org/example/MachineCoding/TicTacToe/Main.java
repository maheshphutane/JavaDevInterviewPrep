package org.example.MachineCoding.TicTacToe;

import org.example.MachineCoding.TicTacToe.controllers.GameController;
import org.example.MachineCoding.TicTacToe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GameController gameController = new GameController();

        System.out.println("Lets begin Tic Tac Toe ....");

        System.out.println("What dimension of board do you need?");
        int dimension = sc.nextInt();

        System.out.println("How many total Players?");
        int numberOfPlayers = sc.nextInt();

        System.out.println("Is there a bot? y/n");
        String isBot = sc.next();
        int nonBotPlayers = numberOfPlayers;
        if (isBot.equals("y")) {
            nonBotPlayers -= 1;
        }

        List<Player> playerList = new ArrayList<>();
        if (isBot.equals("y")) {
            System.out.println("Enter the name of the bot ");
            String playerName = sc.next();
            System.out.println("Enter the symbol for the bot ");
            String symbol = sc.next();

            playerList.add(
                    new Bot(playerName, nonBotPlayers, symbol.charAt(0),

                            BotDifficultyLevel.EASY, sc));
        }
        for (int i = 0; i < nonBotPlayers; i++) {
            System.out.println("Enter the name of the player " + (i+1));
            String playerName = sc.next();
            System.out.println("Enter the symbol for the player ");
            String symbol = sc.next();

            playerList.add(
                    new Player(playerName, symbol.charAt(0),
                            i, PlayerType.HUMAN, sc));
        }



        Game game = GameController.createGame(dimension, playerList);

        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {
            System.out.println("This is the current board: ");

            gameController.displayBoard(game);

            // TODO: Add undo check here.

            gameController.executeNextMove(game);
        }

        System.out.println("Result of the game: ");
        gameController.displayBoard(game);
        if (gameController.getGameState(game).equals(GameState.DRAW)) {
            System.out.println("\nDRAW");
        } else {
            System.out.println("\nThe winner is: " + gameController.getWinner(game).getName());
        }

    }

}
