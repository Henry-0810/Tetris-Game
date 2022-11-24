package TetrisGame.GUI;

import TetrisGame.GUI.GameMainMenu;

import java.awt.*;

public class MainRunFunc {
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
