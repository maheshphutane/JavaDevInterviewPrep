package org.example.MachineCoding.TicTacToe.models;

import org.example.MachineCoding.TicTacToe.stratergies.winningStratergies.WinningStratergy;

import java.util.ArrayList;
import java.util.List;
public class Game {
    Board board;
    List<Player> playerList;
    List<Move> moveList;
    Player nextPlayerTurn;
    GameState gameState;
    int currentPlayerIndex;
    Player winner;
    List<WinningStratergy> winningStrategies;

    private Game(int dimensions, List<Player> playerList, List<WinningStratergy> winningStrategies) {
        this.board = new Board(dimensions);
        this.playerList = playerList;
        this.moveList = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void updateBoard(Move move) {
        // Update the board with the move taken.
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        // Updating the cell in the board with the move that player took.
        this.board.getBoard().get(row).set(col, move.getCell());
    }

    public static class Builder{
        List<Player> playerList;
        List<WinningStratergy> winningStratergies;
        int dimensions;

        public Builder() {
            this.playerList = new ArrayList<>();
            this.winningStratergies = new ArrayList<>();
            this.dimensions = 0;
        }

        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        public Builder setWinningStratergies(List<WinningStratergy> winningStratergies) {
            this.winningStratergies = winningStratergies;
            return this;
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder addPlayer(Player player){
            this.playerList.add(player);
            return this;
        }

        public Builder addWinningStrategry(WinningStratergy winningStratergy){
            this.winningStratergies.add(winningStratergy);
            return this;
        }

        public Game build(){
            return new Game(dimensions,playerList,winningStratergies);
        }
    }

    public Board getBoard(){
        return board;
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }
    public Player getCurrentPlayer(){
        return playerList.get(currentPlayerIndex);
    }

    public void nextPlayerTurn(){
        this.currentPlayerIndex = (this.currentPlayerIndex+1)%playerList.size();
    }

    public void setWinner(Player player){
        this.winner = player;
    }

    public List<WinningStratergy> getWinningStratergy(){
        return this.winningStrategies;
    }
    public Player getWinner(){
        return winner;
    }

    public void addMove(Move move){
        this.moveList.add(move);
    }
}
