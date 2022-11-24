package GUI;

import java.io.*;

public class Serialization {
    private String playerName;
    public Serialization(String playerName) throws IOException {

        try {
            FileWriter recordLastPlayer = new FileWriter("GUI/additionalFiles/LastPlayer.txt");
            setPlayerName(playerName);
            recordLastPlayer.write(getPlayerName());
            recordLastPlayer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
