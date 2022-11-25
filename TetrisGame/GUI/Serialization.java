package TetrisGame.GUI;

import java.io.*;

public class Serialization {
    private int score;
    private String playerName;
    public Serialization(String playerName, int score) throws IOException {

        try {
            FileWriter recordLastPlayer = new FileWriter("TetrisGame/GUI/additionalFiles/LastPlayer.txt");
            setPlayerName(playerName);
            setScore(score);
            recordLastPlayer.write(getPlayerName() + "\nHe/She scored " + getScore());
            recordLastPlayer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
