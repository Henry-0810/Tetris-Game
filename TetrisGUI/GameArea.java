package TetrisGUI;

import TetrisBlocks.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameArea extends JPanel {
    private int gRows;
    private int gCellSize;
    //Creating tetris blocks using this class
    private Blocks blocks;
    private ArrayList<Blocks> allBlocks;
    private Color[][] bgBlocks; //used color as the array type because diff shapes have diff colors
    private int linesCleared = 0;

    public GameArea() {
        this.setBounds(300, 5, 300, 600);
        this.setBackground(Color.black);
        Border borderLine = BorderFactory.createLineBorder(Color.white);
        this.setBorder(borderLine);

        setGCellSize();
        setGRows();

        bgBlocks = new Color[getGRows()][getGCols()];
        allBlocks = new ArrayList<>();
        allBlocks.add(new SquareShape());
        allBlocks.add(new LShape());
        allBlocks.add(new OpLShape());
        allBlocks.add(new ZShape());
        allBlocks.add(new OpZShape());
        allBlocks.add(new IShape());
        allBlocks.add(new TShape());

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
        int rngIndex = new Random().nextInt(allBlocks.size());
        blocks = allBlocks.get(rngIndex); //spawns random blocks

        blocks.spawnBlockCords(getGCols());
    }


    //check if blocks at the bottom, it's a private function because it's only for validation purposes in this class
    private boolean validBlocksDrop(){
        if(blocks.getBottomGrid() == getGRows()){
            return false;
        }

        int[][] shape = blocks.getShape();
        int w = blocks.getBlockWidth();
        int h = blocks.getBlockHeight();

        for (int c = 0; c < w; c++) {
            for (int r = h-1; r >= 0; r--) {
                if(shape[r][c] !=0){
                    int x = c + blocks.getX();
                    int y = r + blocks.getY() + 1;
                    if(y<0) break; //meaning that if y is still above the grid, this validation would not be used
                    if(bgBlocks[y][x] != null) return false; //if(the bgBlocks is null, blocks can be dropped and vice versa
                    break;
                }
            }
        }
        return true;
    }
    //prevent blocks to exceed left and right border
    private boolean validLeftBorder(){
       if(blocks.getLeftBorder() == 0){
           return false;
       }
        int[][] shape = blocks.getShape();
        int w = blocks.getBlockWidth();
        int h = blocks.getBlockHeight();

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if(shape[r][c] !=0){
                    int x = c + blocks.getX() - 1;
                    int y = r + blocks.getY();
                    if(y<0) break; //meaning that if y is still above the grid, this validation would not be used
                    if(bgBlocks[y][x] != null) return false; //if(the bgBlocks is null, blocks can be moved and vice versa
                    break;
                }
            }
        }
       return true;
    }

    private boolean validRightBorder(){
        if(blocks.getRightBorder() == getGCols()){
            return false;
        }
        int[][] shape = blocks.getShape();
        int w = blocks.getBlockWidth();
        int h = blocks.getBlockHeight();

        for (int r = 0; r < h; r++) {
            for (int c = w-1; c >= 0; c--) {
                if(shape[r][c] !=0){
                    int x = c + blocks.getX() + 1;
                    int y = r + blocks.getY();
                    if(y<0) break; //meaning that if y is still above the grid, this validation would not be used
                    if(bgBlocks[y][x] != null) return false; //if(the bgBlocks is null, blocks can be moved and vice versa
                    break;
                }
            }
        }
        return true;
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
    public void setBlocksToBg(){
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

    //let blocks drop automatically until the bottom grid
    public boolean blocksDrop(){

        if(!validBlocksDrop()){
            return false;
        }
        blocks.drop();
        repaint();
        return true;
    }
    //move L & R, instantly drop the block, and rotate the block
    public void moveBlockR(){
        if(blocks == null) return;
        if(!validRightBorder())return;

        blocks.moveR();
        repaint(); //to make it less laggy
    }

    public void moveBlockL(){
        if(blocks == null) return;
        if(!validLeftBorder())return;

        blocks.moveL();
        repaint();
    }
    public void instantDropBlock(){
        if(blocks == null) return;
        while(validBlocksDrop()){
            blocks.drop();
        }
        repaint();
    }
    public void rotateBlock(){
        if(blocks == null) return;
        blocks.rotate();
        //make it so blocks won't rotate out of bounds
        if(bgBlocks != null) return;
        if(blocks.getLeftBorder() < 0) blocks.setX(0);
        if(blocks.getRightBorder() >= getGCols()) blocks.setX(getGCols()-blocks.getBlockWidth());
        if(blocks.getBottomGrid() >= getGRows()) blocks.setY(getGRows() - blocks.getBlockHeight());
        repaint();
    }


    //clear complete lines
    public int clearCompleteLines(){
        boolean validCompleteLines;
        for (int r = getGRows()-1; r >= 0; r--) {
            validCompleteLines = true;
            for (int c = 0; c < getGCols(); c++) {
                if(bgBlocks[r][c] == null) {
                    validCompleteLines = false;
                    break;
                }
            }

            if(validCompleteLines){
                linesCleared++;
                GameFrame.refreshScores(linesCleared);
                for (int i = 0; i < getGCols(); i++) {
                    bgBlocks[r][i] = null;
                }

                shiftDown(r);

                for (int i = 0; i < getGCols(); i++) {
                    bgBlocks[0][i] = null;
                }

                r++;
                repaint();
            }
        }
        return linesCleared;
    }

    public boolean isGameOver(){
        if(blocks.getY() < 0){
            blocks = null;
            return true;
        }
        return false;
    }

    private void shiftDown(int row) {
        for (int r = row; r > 0; r--) {
            for (int c = 0; c < getGCols(); c++) {
                bgBlocks[r][c] = bgBlocks[r-1][c];
            }
        }
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
        drawBG(g);
        drawBlocks(g);
    }
}
