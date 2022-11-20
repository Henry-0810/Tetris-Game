package TetrisGUI;

import java.awt.*;

public class Blocks {
    private int[][] shape;
    private Color color;
    private int x, y;
    private int[][][] rotatedShapes; //all shapes can rotate 4 times, this shapes array is to store all rotations of a shape
    private int currRotation;

    public Blocks(int[][] shape, Color color) {
        setShape(shape);
        setColor(color);

        rotation();
    }

    public void spawnBlockCords(int gridWidth) {
        //these 2 lines must be added b4 the x & y initialization of the block
        currRotation = 0; //everytime the shape spawns, set to the original rotation
        shape = rotatedShapes[currRotation];

        //basically 0-height for y and sum of gridwidth and blockwidth/2 for x
        //which lets the blocks to spawn right above the grid
        x = (gridWidth - getBlockWidth()) / 2;
        y = -getBlockHeight();
    }

    //a method to set rotation of a shape to 4
    private void rotation(){
        rotatedShapes = new int[4][][]; //only consists of 4 rotations

        for (int i = 0; i < 4; i++) {
            int r = shape[0].length;
            int c = shape.length;

            rotatedShapes[i] = new int[r][c];

            for (int y = 0; y < r; y++) {
                for (int x = 0; x < c; x++) {
                    rotatedShapes[i][y][x] = shape[c-x-1][y]; //90 degree rotation
                }
            }

            shape = rotatedShapes[i]; //setting a new shape as the current rotation of the shape
        }
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

    public void rotate(){
        currRotation++;
        if(currRotation>3) currRotation = 0;
        setShape(rotatedShapes[currRotation]);

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
