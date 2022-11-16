package TetrisGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameForm extends JFrame {
    Image img;
    GameArea gameArea = new GameArea();

    public GameForm(){
        this.setTitle("Tetris 2.0");
        JPanel bgFrame = new BGPanel();
        this.setContentPane(bgFrame);
        //add gameArea
        this.add(gameArea);
        this.setSize(900,650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private static class BGPanel extends JPanel
    {
        Image image;
        public BGPanel()
        {
            try
            {
                image = Toolkit.getDefaultToolkit().createImage("TetrisGUI/GameFormBG.png");
            }
            catch (Exception e) { /*handled in paintComponent()*/ }
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if (image != null)
                g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
        }
    }
}




