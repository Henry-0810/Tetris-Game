package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GameOver extends JFrame {
    ImageIcon imageIcon = new ImageIcon("GUI/additionalFiles/GameIcon.png"); //game icon
    public GameOver(){
        this.setTitle("Tetris 2.0");
        JPanel bgPanel = new JPanel();
        bgPanel.setBackground(Color.black);
        this.setContentPane(bgPanel);
        JPanel gameOverPanel = new GameOverPanel();
        this.add(gameOverPanel);
        this.setIconImage(imageIcon.getImage());
        this.setSize(500,500);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //https://docs.oracle.com/javase/7/docs/api/java/util/Timer.html
        //a small try on Timer class
        Timer timer = new Timer(6000, e -> {
            GameOver.this.dispose();
            Object input = JOptionPane.showInputDialog(null,"It's over... Enter username!",
                   "Tetris 2.0",JOptionPane.QUESTION_MESSAGE,imageIcon,null,"");
            if(input != null) {
                String playerName = input.toString();
//                ArrayList<String> players = new ArrayList<>(5);
//                players.add(playerName);
//                if(players.size() > 5){
//                    players.remove(0);
//                }
                try{
                    Serialization saveFile = new Serialization(playerName);
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
            else {
                int choices = JOptionPane.showConfirmDialog(null, "Thank you! Play again?",
                        "Tetris 2.0", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, imageIcon);
                if (choices == JOptionPane.YES_OPTION) {
                    GameDifficulty gameDifficulty = new GameDifficulty();
                    gameDifficulty.setVisible(true);
                } else {
                    GameMainMenu gameMainMenu = new GameMainMenu();
                    gameMainMenu.setVisible(true);
                }
            }
        });
        timer.start();
        timer.setRepeats(false);
    }

    private static class GameOverPanel extends JPanel
    {
        Image image;
        public GameOverPanel()
        {
            this.setBounds(-10,0,500,500);
            try
            {
                image = Toolkit.getDefaultToolkit().createImage("GUI/additionalFiles/GameOverBG.gif");
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
