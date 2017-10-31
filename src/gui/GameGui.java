package gui;

import javax.swing.*;
import game.GameBoard;




public class GameGui extends JPanel {

    private GameBoard gameBoard = new GameBoard();

    public GameGui() {

        JButton newGameButton = new JButton("New Game");
        BoardGui boardGui = new BoardGui(gameBoard);
        boardGui.setBackground(null);

        newGameButton.addActionListener(actionEvent -> {
            gameBoard.newGame();
            boardGui.repaint();
        });



        add(newGameButton);

        add(boardGui);
        setVisible(true);

    }
}
