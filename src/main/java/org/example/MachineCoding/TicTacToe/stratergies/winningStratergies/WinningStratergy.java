package org.example.MachineCoding.TicTacToe.stratergies.winningStratergies;

import org.example.MachineCoding.TicTacToe.models.Board;
import org.example.MachineCoding.TicTacToe.models.Move;

public interface WinningStratergy {
    public boolean isWinPossible(Board board, Move move);
}
