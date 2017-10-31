package game;


import domain.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard {

    private int rowNumber = 4;
    private int columnNumber = 4;

    private boolean finished;
    private Tile[][] board = new Tile[4][4];

    public void newGame() {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        int listIndex = 0;
        for (int rowIndex = 0; rowIndex < rowNumber; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columnNumber; columnIndex++) {
                this.board[rowIndex][columnIndex] = new Tile(numbers.get(listIndex), columnIndex, rowIndex);
                listIndex++;
            }
        }
    }

    public Tile[][] getBoard() {
        return board;
    }



    public boolean isFinished() {
        return finished;
    }

    public void checkIfFinished() {

        List<Integer> list = new ArrayList<>();

        for(int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                list.add(board[row][column].getNumber());
            }
        }

        boolean sorted = true;
        list.remove(list.size()-1); //remove last element that should be '0'
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).compareTo(list.get(i+1)) > 0) sorted = false;
        }

        this.finished = sorted;
    }

    public void moveTile(int row, int column) {

        int[] newPosition = getMovePosition(row, column);

        if (newPosition != null) {
            int newRow = newPosition[0];
            int newColumn = newPosition[1];

            Tile temp = board[row][column];

            board[row][column] = board[newRow][newColumn];
            board[newRow][newColumn] = temp;
        }

        checkIfFinished();
    }

    private int[] getMovePosition(int row, int column) {

        int[] emptyTile = null;

        //check all neighbour tiles if move is permitted and return position

        //right
        if (row < 3 && board[row + 1][column].getNumber() == 0) {
            emptyTile = new int[] { row + 1, column };
        }

        //left
        else if (row > 0 && board[row - 1][column].getNumber() == 0) {
            emptyTile = new int[] { row - 1, column };
        }

        //above
        else if (column > 0 && board[row][column - 1].getNumber() == 0) {
            emptyTile = new int[] { row, column - 1 };
        }

        //below
        else if (column < 3 && board[row][column + 1].getNumber() == 0) {
            emptyTile = new int[] { row, column + 1 };
        }

        return emptyTile;
    }
}

