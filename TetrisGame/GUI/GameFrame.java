/**
 * This package is creates GUI, algorithms and runs the game.**/
package TetrisGame.GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**Instantiate a GameFrame object that adds GameArea frame into it
 * **/
public class GameFrame extends JFrame {
    ImageIcon imageIcon = new ImageIcon("TetrisGame/GUI/additionalFiles/GameIcon.png"); //game icon
    private GameThread gameThread;
    private GameArea gameArea;
    private static final GameLabels gameLabels = new GameLabels();
    /**
    * The constructor of this game
    * **/
    public GameFrame(){
        this.setTitle("Tetris 2.0");
        JPanel bgFrame = new BGPanel();
        JButton backBtn = new BackBtn();
        this.setContentPane(bgFrame);
        //add gameArea
        setGameArea();
        this.add(getGameArea());
        this.add(gameLabels);
        this.add(backBtn);
        this.setSize(900,650);
        this.setIconImage(imageIcon.getImage());
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        keyBinds();
    }
    /**
    * Getters for Game Area (The tetris grid pane)
     * **/
    public GameArea getGameArea() {
        return gameArea;
    }
    /**
     * Setters for Game Area (The tetris grid pane)
     * **/
    public void setGameArea() {
        this.gameArea = new GameArea();
    }
    /**
     * Key-binds for the game
     * **/
    private void keyBinds(){
        //https://docs.oracle.com/javase/7/docs/api/javax/swing/InputMap.html
        //https://docs.oracle.com/javase/7/docs/api/javax/swing/ActionMap.html
        InputMap im = this.getRootPane().getInputMap();
        ActionMap am = this.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke("UP"),"rotate");
        im.put(KeyStroke.getKeyStroke("SPACE"),"instant");
        im.put(KeyStroke.getKeyStroke("LEFT"),"moveL");
        im.put(KeyStroke.getKeyStroke("RIGHT"),"moveR");

        //https://docs.oracle.com/javase/7/docs/api/javax/swing/AbstractAction.html
        am.put("rotate", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameArea.rotateBlock();
            }
        });
        am.put("instant", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameArea.instantDropBlock();
            }
        });
        am.put("moveL", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameArea.moveBlockL();
            }
        });
        am.put("moveR", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameArea.moveBlockR();
            }
        });



    }
    /**
    * Start Tetris Game
    * **/
    public void gameStart(){
        gameThread = new GameThread(gameArea,this);
        gameThread.start();
    }

    /**
    * Refreshes score everytime a player clears line**/
    public static void refreshScores(int score){
        gameLabels.getScoreLabel().setText("Score: " + score);
    }

    /**
    * Display the game mode chose by the player
    * **/
    public static void modes(String mode){
        gameLabels.getModeLabel().setText("Mode: " + mode);
    }

    /**
    * Adds image to the panel and set it as the main frame's content pane
    * **/
    //https://coderanch.com/wiki/660351/Background-Image-JPanel
    //code below is to change the background of my JFrame by adding a background image panel to it
    private static class BGPanel extends JPanel
    {
        Image image;
        public BGPanel()
        {
            try
            {
                image = Toolkit.getDefaultToolkit().createImage("TetrisGame/GUI/additionalFiles/GameFormBG.png");
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

    /**
    * A class for creating back buttons
    * **/
    public class BackBtn extends JButton{
        ImageIcon img = new ImageIcon("TetrisGame/GUI/additionalFiles/BackBtnIcon.png");
        public BackBtn(){
            this.setIcon(img);
            this.setBounds(0,10,50,60);
            this.setBackground(new Color(0f,0f,0f,0.5f));
            this.setFont(new Font("Monospaced",Font.PLAIN,6));
            this.setBorder(new LineBorder(Color.white));
            this.addActionListener(new BackToMainMenu());
        }
    }

    /**
    * Button's action listener that closes this frame and show the Game Difficulty frame
    * **/
    public class BackToMainMenu implements ActionListener
    {
        //@SuppressWarnings("deprecation")
        public void actionPerformed(ActionEvent action)
        {
            GameDifficulty gameDifficulty = new GameDifficulty();
            gameDifficulty.setVisible(true);

            GameFrame.this.dispose();
        }
    }
}




