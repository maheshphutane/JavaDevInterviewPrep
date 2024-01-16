package org.example.MachineCoding.TicTacToe.stratergies.winningStratergies;

import org.example.MachineCoding.TicTacToe.models.Board;
import org.example.MachineCoding.TicTacToe.models.Move;
import org.example.MachineCoding.TicTacToe.models.CellStatus;

public class CornerWinningStratergy implements WinningStratergy{
    @Override
    public boolean isWinPossible(Board board, Move move) {
        int n = board.getBoard().size();
        char Symbol = move.getCell().getPlayer().getSymbol();

        int[] row = new int[]{0,0,n-1,n-1};
        int[] col = new int[]{0,n-1,0,n-1};
        for(int i = 0;i<4;i++){
            if(board.getBoard().get(row[i]).get(col[i]).getCellStatus().equals(CellStatus.EMPTY) ||
                    board.getBoard().get(row[i]).get(col[i]).getPlayer().getSymbol()!=Symbol){
                return false;
            }
        }
        return true;
    }
}
