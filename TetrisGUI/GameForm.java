package TetrisGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameForm extends JFrame {
    public GameForm(){
        this.setTitle("Tetris 2.0");
        //add gameArea
        this.add(new GameArea());
        this.setSize(900,650);

        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("GameFormBG.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }



}




