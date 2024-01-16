package org.example.MachineCoding.TicTacToe.stratergies.Bot;

import org.example.MachineCoding.TicTacToe.models.Board;
import org.example.MachineCoding.TicTacToe.models.Move;

public interface BotPlayingStratergy {
    Move suggestMove(Board board);
}
