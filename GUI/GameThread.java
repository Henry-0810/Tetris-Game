package GUI;

import java.util.concurrent.atomic.AtomicBoolean;


//https://www.w3schools.com/java/java_threads.asp learn a few basics from this website
public class GameThread extends Thread{
    private final AtomicBoolean runner = new AtomicBoolean(false);
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

                gameFrame.dispose();
                GameOver gameOver = new GameOver();
                gameOver.setVisible(true);
                break;
            }

            gameArea.setBlocksToBg();
        }
    }

}
