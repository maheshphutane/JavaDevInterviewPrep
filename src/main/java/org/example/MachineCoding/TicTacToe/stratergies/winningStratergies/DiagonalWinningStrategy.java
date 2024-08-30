package org.example.MachineCoding.TicTacToe.stratergies.winningStratergies;

import org.example.MachineCoding.TicTacToe.models.Board;
import org.example.MachineCoding.TicTacToe.models.Cell;
import org.example.MachineCoding.TicTacToe.models.CellStatus;
import org.example.MachineCoding.TicTacToe.models.Move;

public class DiagonalWinningStrategy implements WinningStratergy{
    @Override
    public boolean isWinPossible(Board board, Move move) {
        Cell cell = move.getCell();
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        for(int i = 0;i<board.getBoard().size();i++){
            if (board.getBoard().get(i).get(i).getCellStatus().equals(CellStatus.EMPTY) ||
                    board.getBoard().get(i).get(i).getPlayer().getSymbol() != cell.getPlayer().getSymbol()) {
                diagonal1 = false;
                break;
            }
        }
        for(int i = 0;i<board.getBoard().size();i++){
            if (board.getBoard().get(i).get(board.getBoard().size() - 1 - i).getCellStatus().equals(CellStatus.EMPTY) ||
                    board.getBoard().get(i).get(board.getBoard().size() - 1 - i).getPlayer().getSymbol() != cell.getPlayer().getSymbol()) {
                diagonal2 = false;
                break;
            }
        }
        return diagonal1 || diagonal2;
    }
}
