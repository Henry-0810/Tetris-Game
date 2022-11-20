package TetrisGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameArea extends JPanel {
    private int gRows;
    private int gCellSize;
    //Creating tetris blocks using this class
    private Blocks blocks;
    private Color[][] bgBlocks; //used color as the array type because diff shapes have diff colors

    public GameArea() {
        this.setBounds(300, 5, 300, 600);
        this.setBackground(Color.black);
        Border borderLine = BorderFactory.createLineBorder(Color.white);
        this.setBorder(borderLine);

        setGCellSize();
        setGRows();

        bgBlocks = new Color[getGRows()][getGCols()];

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

    public boolean blocksDrop(){

        if(!validBlocksDrop()){
            setBlocksToBg();
            return false;
        }
        blocks.drop();
        repaint();
        return true;
    }

    //check if blocks at the bottom, it's a private function because it's only for validation purposes in this class
    private boolean validBlocksDrop(){
        return blocks.getBottomGrid() != getGRows();
    }

    private void drawBlocks(Graphics g) {
        //created 4 new variables so that getters don't have to reuse over and over
        int[][] shape = blocks.getShape();
        Color color = blocks.getColor();
        int h = blocks.getBlockHeight();
        int w = blocks.getBlockWidth();

        for (int row = 0; row < h; row++)
        {
            for (int col = 0; col < w; col++)
            {
                if (shape[row][col] == 1) {

                    int x = (blocks.getX() + col) * getGCellSize();
                    int y = (blocks.getY() + row) * getGCellSize();

                    drawGrid(g,color,x,y);
                }
            }
        }
    }
    //draw block bg
    private void drawBG(Graphics g){
        Color blockColor;
        for (int row = 0; row < getGRows(); row++) {
            for (int col = 0; col < getGCols(); col++) {

                blockColor = bgBlocks[row][col];

                if(blockColor != null){
                    //if the block on grid has color, draw the grid
                    int x = col*getGCellSize();
                    int y = row*getGCellSize();
                    drawGrid(g,blockColor,x,y);
                }
            }
        }
    }

    //set blocks become background
    private void setBlocksToBg(){
        int[][] shape = blocks.getShape();
        Color color = blocks.getColor();
        int h = blocks.getBlockHeight();
        int w = blocks.getBlockWidth();

        int x = blocks.getX();
        int y = blocks.getY();

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w;col++) {
                if(shape[row][col] == 1){
                    bgBlocks[row + y][col + x] = color;
                }
            }
        }
    }
    //move L & R, instantly drop the block, and rotate the block
    public void moveBlockR(){
        blocks.moveR();
        repaint();
    }

    public void moveBlockL(){
        blocks.moveL();
        repaint();
    }
    public void instantDropBlock(){
        while(validBlocksDrop()){
            blocks.drop();
        }
        repaint();
    }
    public void rotateBlock(){
        blocks.rotate();
        repaint();
    }

    //draw grid
    private void drawGrid(Graphics grids, Color color, int x, int y){
        grids.setColor(color);
        grids.fillRect(x, y, getGCellSize(), getGCellSize());
        grids.setColor(Color.black);
        grids.drawRect(x, y, getGCellSize(), getGCellSize());
    }

    /*to make a line become a square, it requires two coordinates,
    therefore needs 2 loops to paint the grid of tetris board*/
    protected void paintComponent(Graphics g) { //Graphics r learned from https://www.javatpoint.com/Graphics-in-swing
        super.paintComponent(g);
        drawBlocks(g);
        drawBG(g);
    }
}
