package TetrisGUI;

import javax.swing.*;
import java.awt.*;

public class Tetris {
    public static Font font = null;
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //GameFrame tetris = new GameFrame();
                GameMainMenu tetrisMainMenu = new GameMainMenu();

                //tetris.gameStart();
            }
        });
    }
}
