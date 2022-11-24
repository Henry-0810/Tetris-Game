import GUI.GameMainMenu;
import GUI.Serialization;

import java.awt.*;
import java.io.IOException;

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
