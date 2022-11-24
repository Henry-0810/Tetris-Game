package GUI;

import java.io.*;

public class Serialization {
    private String playerName;
    public Serialization(String playerName) throws IOException {

        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter("GUI/additionalFiles/leaderboard.txt"));
            writer.write("This is the 5 previous player that played Tetris 2.0:\n");
            setPlayerName(playerName);
            writer.write(getPlayerName());

        }
        catch ( IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if ( writer != null)
                    writer.close( );
            }
            catch ( IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
