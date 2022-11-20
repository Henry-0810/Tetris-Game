package TetrisGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {
    private final GameArea gameArea = new GameArea();
    private final GameLabels gameLabels = new GameLabels();

    public GameFrame(){
        this.setTitle("Tetris 2.0");
        JPanel bgFrame = new BGPanel();
        this.setContentPane(bgFrame);
        //add gameArea
        this.add(gameArea);
        this.add(gameLabels);
        this.setSize(900,650);
        this.setLayout(null);
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

    public void refreshScores(int score){}

    public void refreshLevels(String level){

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




