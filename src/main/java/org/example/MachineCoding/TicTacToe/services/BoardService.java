package org.example.MachineCoding.TicTacToe.services;

import org.example.MachineCoding.TicTacToe.models.Board;
import org.example.MachineCoding.TicTacToe.models.CellStatus;

public class BoardService {
    public static void display(Board board){
        int size = board.getBoard().size();
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)){
                    System.out.printf("|   |");
                }
                else{
                    System.out.printf("| %s |",board.getBoard().get(i).get(j).getPlayer().getSymbol());
                }
            }
            System.out.println();
        }
    }
}
