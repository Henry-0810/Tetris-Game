package GUI;

import javax.swing.*;
import java.awt.*;

public class GameForm extends JFrame {
    public static void main(String[] args) {
        JFrame gameFrame = new JFrame("Tetris 2.0");

        //adding game screen
        gameFrame.add(getGameScreen());
        gameFrame.setSize(900, 650);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

    }

    public static Component getGameScreen() {
        JPanel gameScreen = new JPanel();
        gameScreen.setSize(300, 650);
        gameScreen.setLocation(300,300);
        gameScreen.setBackground(Color.black);
        return gameScreen;
    }


}




