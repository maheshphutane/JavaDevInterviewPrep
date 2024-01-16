package org.example.MachineCoding.TicTacToe.controllers;

import org.example.MachineCoding.TicTacToe.models.Game;
import org.example.MachineCoding.TicTacToe.models.GameState;
import org.example.MachineCoding.TicTacToe.models.Player;
import org.example.MachineCoding.TicTacToe.services.BoardService;
import org.example.MachineCoding.TicTacToe.services.GameService;
import org.example.MachineCoding.TicTacToe.stratergies.winningStratergies.ColumnWinningStratergy;
import org.example.MachineCoding.TicTacToe.stratergies.winningStratergies.CornerWinningStratergy;
import org.example.MachineCoding.TicTacToe.stratergies.winningStratergies.RowWinningStratergy;

import java.util.List;

public class GameController {
    public static Game createGame(int dimensions, List<Player> playerList){
        return Game.getBuilder()
                .setDimensions(dimensions)
                .setPlayerList(playerList)
                .addWinningStrategry(new ColumnWinningStratergy())
                .addWinningStrategry(new RowWinningStratergy())
                .addWinningStrategry(new CornerWinningStratergy())
                .build();
    }

    public void displayBoard(Game game){
        BoardService.display(game.getBoard());
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void executeNextMove(Game game){
        GameService gameService = new GameService(game);
        gameService.executeMove();
    }
}
