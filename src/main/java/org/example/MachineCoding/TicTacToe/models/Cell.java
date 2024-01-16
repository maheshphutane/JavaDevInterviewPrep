package org.example.MachineCoding.TicTacToe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int row;
    private int col;

    private CellStatus cellStatus;
    private Player player;

    public Cell(int row,int col){
        this.row = row;
        this.col = col;
        this.cellStatus = CellStatus.EMPTY;
    }

    public Cell(int row, int col, CellStatus cellStatus,Player player){
        this.row = row;
        this.col = col;
        this.cellStatus = cellStatus;
        this.player = player;

    }

    public Cell(Cell cell) {
        this.row = cell.getRow();
        this.col = cell.getCol();
        this.cellStatus = cell.getCellStatus();
        this.player = cell.getPlayer();
    }
}
