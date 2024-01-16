package org.example.MachineCoding.TicTacToe.stratergies.winningStratergies;

import org.example.MachineCoding.TicTacToe.models.Board;
import org.example.MachineCoding.TicTacToe.models.Move;
import org.example.MachineCoding.TicTacToe.models.Cell;
import org.example.MachineCoding.TicTacToe.models.CellStatus;

public class ColumnWinningStratergy implements WinningStratergy{
    @Override
    public boolean isWinPossible(Board board, Move move) {
        Cell cell = move.getCell();
        int col = cell.getCol();
        for(int i = 0;i<board.getBoard().size();i++){
            if(board.getBoard().get(i).get(col).getCellStatus().equals(CellStatus.EMPTY) ||
                    board.getBoard().get(i).get(col).getPlayer().getSymbol()!=cell.getPlayer().getSymbol()){
                return false;
            }
        }
        return true;
    }
}
