package org.example.MachineCoding.TicTacToe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    private char symbol;
    private int id;
    private PlayerType playerType;
    private Scanner scanner;
    //TODO(Mahesh): Add a methode to make move.

    public Move makeMove(Board board){
        int n = board.getBoard().size();
        int currNumberOfOccupiedCells = board.getOccupiedCellCount();
        if(currNumberOfOccupiedCells==n*n) return null;

        System.out.println("Enter the row and column where you want to play the move.");

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        Cell cell = board.getBoard().get(row).get(col);

        System.out.printf("The player %s is making a move at cell: %d, %d\n",
                this.name, cell.getRow(), cell.getCol());

        if(cell.getCellStatus().equals(CellStatus.OCCUPIED)){
            throw new IllegalStateException("This cell is Occupied");
        }

        cell.setPlayer(this);
        cell.setCellStatus(CellStatus.OCCUPIED);
        board.setOccupiedCellCount(currNumberOfOccupiedCells+1);
        return new Move(cell);
    }

}
