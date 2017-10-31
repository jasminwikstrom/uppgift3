package gui;

import javax.swing.*;
import game.GameBoard;




public class GameGui extends JPanel {

    private GameBoard gameBoard = new GameBoard();

    public GameGui() {

        JButton newGameButton = new JButton("New Game");
        JButton cheatButton = new JButton("Cheat!");
        BoardGui boardGui = new BoardGui(gameBoard);
        boardGui.setBackground(null);

        newGameButton.addActionListener(actionEvent -> {
            gameBoard.newGame();
            boardGui.repaint();
        });



        cheatButton.addActionListener(actionEvent -> {
            gameBoard.newGame();

            boardGui.repaint();
        });



        add(newGameButton);
        add(cheatButton);
        add(boardGui);
        setVisible(true);

    }
}
