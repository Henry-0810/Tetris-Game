package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//https://www.w3schools.com/java/java_threads.asp learn a few basics from this website
public class GameThread extends Thread{
    private GameLabels gameLabels;
    private GameArea gameArea;
    public GameThread(GameArea gameArea){
        setGameArea(gameArea);
    }

    public void setGameArea(GameArea gameArea) {
        this.gameArea = gameArea;
    }
    public static int speed;

    public void setSpeed(int speed) {
        GameThread.speed = speed;
    }

    public static int getSpeed() {
        return speed;
    }

    public void run() {
        while (true) {
            gameArea.createBlocks();

            while(gameArea.blocksDrop()) {
                try {
                    Thread.sleep(getSpeed());
                } catch (InterruptedException e) {
                    Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, e);
                }
            }

//            if(gameLabels.getModeLabel().equals(new JLabel("U a GOD!"))){
//                Timer timer = new Timer(3000, e -> {
//                    if(!gameArea.isGameOver()) {
//                        Winner winner = new Winner();
//                        winner.setVisible(true);
//                    }
//                });
//            }
            //was trying to make aa timer for the hardest game mode, if survive after 30 seconds, player name will be stored in Hall of fame file
            if(gameArea.isGameOver()){
                GameOver gameOver = new GameOver();
                gameOver.setVisible(true);
                break;
            }

            gameArea.setBlocksToBg();

        }


    }
}
