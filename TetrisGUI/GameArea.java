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
    //Creating tetris blocks using this class
    private TetrisBlocks blocks;

    public GameArea(){
        this.setBounds(300,5,300,600);
        this.setBackground(Color.black);
        Border borderLine = BorderFactory.createLineBorder(Color.white);
        this.setBorder(borderLine);

        setGCellSize();
        setGRows();
        createBlocks();
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

    public void createBlocks(){
        blocks = new TetrisBlocks(new int[][]{{1,0},{1,0},{1,1}},Color.orange);
    }
    private void drawBlocks(Graphics g) {
        //created 4 new variables so that getters don't have to reuse over and over
        int[][] shape = blocks.getShape();
        Color color = blocks.getColor();
        int h = blocks.getBlockHeight();
        int w = blocks.getBlockWidth();

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (shape[row][col] == 1) {
                    g.setColor(color);
                    g.fill3DRect(col * getGCellSize(), row * getGCellSize(), getGCellSize(),
                            getGCellSize(), true);
                    g.setColor(Color.black);
                    g.draw3DRect(col * getGCellSize(), row * getGCellSize(), getGCellSize(),
                            getGCellSize(), true);
                }
            }
        }
    }

    /*to make a line become a square, it requires two coordinates,
    therefore needs 2 loops to paint the grid of tetris board*/
    protected void paintComponent(Graphics grids) { //Graphics r learned from https://www.javatpoint.com/Graphics-in-swing
        super.paintComponent(grids);

        drawBlocks(grids);
    }


}
