package gui;

import domain.Tile;
import game.GameBoard;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardGui extends JPanel implements MouseListener {

    private static final int CELL_SIZE = 95;
    private Font font = new Font("Helvetica", Font.BOLD, CELL_SIZE / 3);
    private GameBoard gameBoard;

    public BoardGui(GameBoard gameBoard) {

        this.gameBoard = gameBoard;
        this.repaint();
        int totalWidth =  CELL_SIZE * 4;
        int totalHeight = CELL_SIZE * 4;

        this.setPreferredSize(new Dimension(totalWidth, totalHeight));
        this.setBackground(Color.DARK_GRAY);
        this.addMouseListener(this);
    }

    // Hämtar aktuella spelbrädet, går igenom brädets tiles och ritar ut dom. Om numret på tilen är 0,skrivs tomma strängen ut
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Tile[][] board = gameBoard.getBoard();
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for (int columnIndex= 0; columnIndex < board.length; columnIndex++) {
                int x = columnIndex * CELL_SIZE;
                int y = rowIndex * CELL_SIZE;
                if (board[rowIndex][columnIndex] != null) {
                    int number = board[rowIndex][columnIndex].getNumber();
                    String paintedNumber = "";
                    if (number != 0) {
                        paintedNumber = Integer.toString(number);
                    }

                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(x + 1, y + 1, CELL_SIZE - 2, CELL_SIZE - 2);
                    g.setColor(Color.pink.darker());
                    g.setFont(font);
                    g.drawString(paintedNumber, x + 30, y + 60);
                }
            }
        }
    }

    public void mousePressed(MouseEvent e) {

        int pressedColumn = e.getX() / CELL_SIZE;
        int pressedRow = e.getY() / CELL_SIZE;

        //try to move tiles
        gameBoard.moveTile(pressedRow, pressedColumn);

        this.repaint();

        if (gameBoard.isFinished()) {
            JOptionPane.showMessageDialog(this, "You have won the game, congratulations");
        }

    }

    @Override public void mouseClicked(final MouseEvent e) { }
    @Override public void mouseReleased(final MouseEvent e) {}
    @Override public void mouseEntered(final MouseEvent e) {}
    @Override public void mouseExited(final MouseEvent e) {}
}
