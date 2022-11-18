package TetrisGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameArea extends JPanel {
    private int gRows;
    private int gCellSize;
    //Creating tetris blocks using this class
    private Blocks blocks;

    public GameArea() {
        this.setBounds(300, 5, 300, 600);
        this.setBackground(Color.black);
        Border borderLine = BorderFactory.createLineBorder(Color.white);
        this.setBorder(borderLine);

        setGCellSize();
        setGRows();
        createBlocks();
    }

    //setters and getters here

    public void setGRows() {
        gRows = this.getBounds().height / getGCellSize();
    }

    public void setGCellSize() {
        gCellSize = this.getBounds().width / getGCols();
    }

    public int getGCols() {
        //g=grid here
        /*To get a perfect square for all cell size, first I divide cellsize with rows and cols to get the ratio
    in order to build a perfect square grid*/
        return 10;
    }

    public int getGCellSize() {
        return gCellSize;
    }
    public int getGRows(){return gRows;}

    //self-defined methods here

    public void createBlocks() {
        blocks = new Blocks(new int[][]{{1, 0}, {1, 0}, {1, 1}}, Color.orange);
        blocks.spawnBlockCords(getGCols());
    }

    public void dropBlocks(){
        //https://stackoverflow.com/questions/7937029/how-to-break-out-or-exit-a-method-in-java
        //if false, exit method and run drop() function
        if(validDropBlock()) return;
        blocks.drop();
        repaint();
    }

    //check if blocks at the bottom, it's a private function because it's only for validation purposes in this class
    private boolean validDropBlock(){
        return blocks.getBottomGrid() == getGRows();
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

                    int x = (blocks.getX() + col) * getGCellSize();
                    int y = (blocks.getY() + row) * getGCellSize();

                    g.setColor(color);
                    g.fillRect(x, y, getGCellSize(), getGCellSize());
                    g.setColor(Color.black);
                    g.drawRect(x, y, getGCellSize(), getGCellSize());
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
