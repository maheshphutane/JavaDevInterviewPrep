package org.example.MachineCoding.TicTacToe.stratergies.winningStratergies;

import org.example.MachineCoding.TicTacToe.models.Board;
import org.example.MachineCoding.TicTacToe.models.Move;
import org.example.MachineCoding.TicTacToe.models.Cell;
import org.example.MachineCoding.TicTacToe.models.CellStatus;

public class RowWinningStratergy implements WinningStratergy{
    @Override
    public boolean isWinPossible(Board board, Move move) {
        Cell cell  = move.getCell();
        int row = cell.getRow();
        for(int i = 0;i<board.getBoard().size();i++){
            if(board.getBoard().get(row).get(i).getCellStatus().equals(CellStatus.EMPTY) ||
               board.getBoard().get(row).get(i).getPlayer().getSymbol()!=cell.getPlayer().getSymbol()){
                return false;
            }
        }
        return true;
    }
}
