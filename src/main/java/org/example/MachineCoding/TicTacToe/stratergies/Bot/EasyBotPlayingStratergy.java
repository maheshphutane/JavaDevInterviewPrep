package org.example.MachineCoding.TicTacToe.stratergies.Bot;

import org.example.MachineCoding.TicTacToe.models.Board;
import org.example.MachineCoding.TicTacToe.models.Move;
import org.example.MachineCoding.TicTacToe.models.Cell;
import org.example.MachineCoding.TicTacToe.models.CellStatus;

public class EasyBotPlayingStratergy implements BotPlayingStratergy{
    @Override
    public Move suggestMove(Board board) {
        for(int i = 0;i<board.getBoard().size();i++){
            for(int j = 0;j<board.getBoard().size();j++){
                Cell cell = board.getBoard().get(i).get(j);
                if(cell.getCellStatus().equals(CellStatus.EMPTY)){
                    return new Move(board.getBoard().get(i).get(j));
                }
            }
        }
        return null;
    }
}
