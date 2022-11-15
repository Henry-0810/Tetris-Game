package TetrisGUI;

import javax.swing.*;
import java.awt.*;

public class GameArea extends JPanel {

    public GameArea(){
        this.setBounds(40,40,300,650);
    }

    protected void paintComponent(Graphics g){
        g.fillRect(0,0,50,50);
    }


}
