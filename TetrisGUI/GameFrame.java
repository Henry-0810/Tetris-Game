package TetrisGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    ImageIcon imageIcon = new ImageIcon("TetrisGUI/additionalFiles/GameIcon.png"); //game icon
    private final GameArea gameArea = new GameArea();
    private static final GameLabels gameLabels = new GameLabels();

    public GameFrame(){
        this.setTitle("Tetris 2.0");
        JPanel bgFrame = new BGPanel();
        JButton backBtn = new BackBtn();
        this.setContentPane(bgFrame);
        //add gameArea
        this.add(gameArea);
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
    public void gameStart(){
        new GameThread(gameArea).start();
    }

    public static void refreshScores(int score){
        gameLabels.getScoreLabel().setText("Score: " + score);
    }


    //https://coderanch.com/wiki/660351/Background-Image-JPanel
    //code below is to change the background of my JFrame by adding a background image panel to it
    private static class BGPanel extends JPanel
    {
        Image image;
        public BGPanel()
        {
            try
            {
                image = Toolkit.getDefaultToolkit().createImage("TetrisGUI/additionalFiles/GameFormBG.png");
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

    public static class BackBtn extends JButton{
        public BackBtn(){
             this.setText("<--");
             this.setBounds(0,0,50,50);
             this.setBackground(new Color(0f,0f,0f,0.5f));
             this.addActionListener(new BackToMainMenu());
        }
    }

    public static class BackToMainMenu implements ActionListener
    {
        //@SuppressWarnings("deprecation")
        public void actionPerformed(ActionEvent action)
        {
            GameMainMenu gameMainMenu = new GameMainMenu();
            gameMainMenu.setVisible(true);

            GameFrame gameFrame = new GameFrame();
            gameFrame.setVisible(false);
            gameFrame.dispose();

        }
    }
}




