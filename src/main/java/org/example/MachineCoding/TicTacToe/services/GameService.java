package org.example.MachineCoding.TicTacToe.services;

import org.example.MachineCoding.TicTacToe.models.Game;
import org.example.MachineCoding.TicTacToe.models.GameState;
import org.example.MachineCoding.TicTacToe.models.Player;
import org.example.MachineCoding.TicTacToe.models.Move;
import org.example.MachineCoding.TicTacToe.stratergies.winningStratergies.WinningStratergy;
public class GameService {
    Game game;

    public GameService(Game game){
        this.game = game;
    }

    public void executeMove() {
        Player currentPlayer = game.getCurrentPlayer();
        System.out.printf("Player turn: %s\n", currentPlayer.getName());

        Move move = currentPlayer.makeMove(game.getBoard());

        if(move==null){
            game.setGameState(GameState.DRAW);
            return;
        }

        game.addMove(move);
        game.updateBoard(move);

        for (WinningStratergy winningStrategy: game.getWinningStratergy()) {
            if (winningStrategy.isWinPossible(game.getBoard(), move)) {

                System.out.printf("The player %s has won.\n", currentPlayer.getName());
                game.setGameState(GameState.WIN);
                game.setWinner(currentPlayer);
                break;
            }
        }

        game.nextPlayerTurn();

    }
}
