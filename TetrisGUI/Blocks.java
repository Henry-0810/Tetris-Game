package TetrisGUI;

import java.awt.*;

public class Blocks {
    private int[][] shape;
    private Color color;
    private int x, y;

    public Blocks(int[][] shape, Color color) {
        setShape(shape);
        setColor(color);
    }

    public void spawnBlockCords(int gridWidth) {
        //basically 0-height for y and sum of gridwidth and blockwidth/2 for x
        //which lets the blocks to spawn right above the grid
        y = -getBlockHeight();
        x = (gridWidth - getBlockWidth()) / 2;
    }

    public int[][] getShape() {
        return shape;
    }

    public void setShape(int[][] shape) {
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //to move the blocks, I use x and y coordinates to maneuver the movements of blocks
    public void drop() {
        y++;    //dropping the blocks
    }

    public void moveL() {
        x--;    //move blocks to left
    }

    public void moveR() {
        x++;    //move blocks to right
    }

    public int getBottomGrid() {
        return y + getBlockHeight();
    }


    public int getBlockHeight() {
        return getShape().length;
    }

    public int getBlockWidth() {
        return getShape()[0].length;
    }
}
