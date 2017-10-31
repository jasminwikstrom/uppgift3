import gui.GameGui ;
import javax.swing.*;

public class FifteenGame {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.add(new GameGui());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
