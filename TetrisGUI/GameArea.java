package TetrisGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameArea extends JPanel {
    //g=grid here
    /*To get a perfect square for all cell size, first I divide cellsize with rows and cols to get the ratio
    in order to build a perfect square grid*/
    private final int gCols = 10;
    private int gRows;
    private int gCellSize;
    private static int iter;

    public GameArea(){
        this.setBounds(300,5,300,600);
        this.setBackground(Color.black);
        Border borderLine = BorderFactory.createLineBorder(Color.black);
        this.setBorder(borderLine);

        setGCellSize();
        setGRows();
    }

    public void setGRows() {
        gRows = this.getBounds().height / getGCellSize();
    }
    public void setGCellSize() {
        gCellSize = this.getBounds().width / getGCols();
    }

    public int getGCols() {
        return gCols;
    }

    public int getGCellSize() {
        return gCellSize;
    }

    public int getGRows() {
        return gRows;
    }

    protected void paintComponent(Graphics grids) {
        super.paintComponent(grids);
        for (int y = 0; y < getGRows(); y++) {
            int x = 0;
            while (x < getGCols()) {
                grids.drawRect(x*getGCellSize(), y*getGCellSize(), getGCellSize(), getGCellSize());
                x++;
            }
        }

    }


}
