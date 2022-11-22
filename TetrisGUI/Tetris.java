package TetrisGUI;

import javax.swing.*;
import java.awt.*;

public class Tetris {
    public static Font font = null;
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameMainMenu tetrisMainMenu = new GameMainMenu();
            }
        });
    }
}
