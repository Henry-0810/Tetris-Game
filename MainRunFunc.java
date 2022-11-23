import GUI.GameFrame;
import GUI.GameMainMenu;
import GUI.GameOver;

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
