package org.example.MachineCoding.TicTacToe.models;

import org.example.MachineCoding.TicTacToe.stratergies.Bot.BotPlayingStratergy;
import org.example.MachineCoding.TicTacToe.stratergies.Bot.BotPlayingStratergyFactory;

import java.util.Scanner;

public class Bot extends Player{

    BotPlayingStratergy botPlayingStratergy;
    BotDifficultyLevel botDifficultyLevel;
    public Bot(String name, int id, char symbol, BotDifficultyLevel botDifficultyLevel, Scanner scanner) {
        super(name, symbol,id, PlayerType.BOT,scanner );
        this.botPlayingStratergy = BotPlayingStratergyFactory.getBotPlayingStratergy(botDifficultyLevel);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board){

        Move move = botPlayingStratergy.suggestMove(board);

        if(move == null) return null;
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        System.out.printf("the bot is making a move %d %d.\n",row ,col );
        board.getBoard().get(row).get(col).setCellStatus(CellStatus.OCCUPIED);
        board.getBoard().get(row).get(col).setPlayer(this);
        board.setOccupiedCellCount(board.getOccupiedCellCount()+1);

        return move;
    }
}
