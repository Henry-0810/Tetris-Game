package TetrisGame.GUI;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;


//https://www.w3schools.com/java/java_threads.asp learn a few basics from this website
public class GameThread extends Thread{
    ImageIcon imageIcon = new ImageIcon("TetrisGame/GUI/additionalFiles/GameIcon.png"); //game icon

    //https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/atomic/AtomicBoolean.html
    private final AtomicBoolean runner = new AtomicBoolean(false);

    private GameLabels gameLabels;
    private GameFrame gameFrame;
    private GameArea gameArea;
    public GameThread(GameArea gameArea, GameFrame gameFrame){

        setGameArea(gameArea);
        this.gameFrame = gameFrame;
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
        runner.set(true);
        while (runner.get()) {
            gameArea.createBlocks();

            while(gameArea.blocksDrop()) {
                try {
                    Thread.sleep(getSpeed());
                } catch (InterruptedException e) {
                    return;
                }
            }


            if(gameArea.isGameOver()){
                Object input = JOptionPane.showInputDialog(null,"It's over... Enter username!",
                        "Tetris 2.0",JOptionPane.QUESTION_MESSAGE,imageIcon,null,"");
                if(input != null) {
                    int scored = gameArea.getScore();
                    String playerName = input.toString();
                    try{
                        Serialization saveFile = new Serialization(playerName,scored);
                    }
                    catch (IOException ex){
                        ex.printStackTrace();
                    }
                }
                gameFrame.dispose();
                GameOver gameOver = new GameOver();
                gameOver.setVisible(true);
                break;
            }

            gameArea.setBlocksToBg();
            gameArea.clearCompleteLines();
        }
    }

    public void restart(){
        runner.set(false);
    }

}
