package TetrisGame;

import TetrisGame.GUI.GameOver;

import javax.swing.*;
import java.awt.*;

public class HallOfFame extends JFrame {
    ImageIcon imageIcon = new ImageIcon("TetrisGame/GUI/additionalFiles/GameIcon.png"); //game icon
    public HallOfFame(){
        this.setTitle("Tetris 2.0");
        JPanel bgPanel = new JPanel();
        JPanel winnerPanel = new WinnerPanel();
        this.setContentPane(winnerPanel);
        this.setIconImage(imageIcon.getImage());
        this.setSize(550,249);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private static class WinnerPanel extends JPanel
    {
        Image image;
        public WinnerPanel()
        {
            this.setBounds(-10,0,500,500);
            try
            {
                image = Toolkit.getDefaultToolkit().createImage("TetrisGame/GUI/additionalFiles/HallOfFame.png");
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
