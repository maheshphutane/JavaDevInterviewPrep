package org.example.MachineCoding.TicTacToe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private int moveNumber;

    private Cell cell;

    public Move(Cell cell){
        this.cell = cell;
        this.moveNumber = 0;
    }


}
