package domain;

//Information om plattorna,värde och position

public class Tile {

    private int number;
    private int column;
    private int row;

    public Tile(int number, int column, int row) {
        this.number = number;
        this.column = column;
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
