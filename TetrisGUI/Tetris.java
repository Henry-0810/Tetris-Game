package TetrisGUI;

import javax.swing.*;
import java.awt.*;

public class Tetris {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameFrame tetris = new GameFrame();

                tetris.gameStart();
            }
        });
    }
}
