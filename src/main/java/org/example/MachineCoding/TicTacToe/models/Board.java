package org.example.MachineCoding.TicTacToe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private List<List<Cell>> board;
    private int occupiedCellCount;
    public Board(int dimensions){
        this.occupiedCellCount = 0;
        this.board = new ArrayList<>();
        for(int i = 0;i<dimensions;i++){
            this.board.add(new ArrayList<>());
            for(int j = 0;j<dimensions;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard(){
        int size = board.size();
//        board.get(1).get(2).setPlayer(new Player("Mahesh",1,'X',PlayerType.HUMAN));
//        board.get(1).get(2).setCellStatus(CellStatus.OCCUPIED);
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(board.get(i).get(j).getCellStatus().equals(CellStatus.EMPTY) || j==0){
                    System.out.printf("| ");
                }
                else{
                    System.out.printf("|%s",board.get(i).get(j).getPlayer().getSymbol());
                }
                if(j==size-1){
                    System.out.printf("|");
                }
            }
            System.out.println();
        }
    }
}
