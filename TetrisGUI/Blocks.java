package TetrisGUI;

import java.awt.*;
import java.util.Random;

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

    //a method to set rotation of a shape to 4
    private void rotation(){
        rotatedShapes = new int[4][][]; //only consists of 4 rotations

        for (int i = 0; i < 4; i++) {
            int r = getBlockWidth();
            int c = getBlockHeight();

            rotatedShapes[i] = new int[r][c];

            for (int y = 0; y < r; y++) {
                for (int x = 0; x < c; x++) {
                    rotatedShapes[i][y][x] = shape[c-x-1][y]; //90 degree rotation
                }
            }

            setShape(rotatedShapes[i]); //setting a new shape as the current rotation of the shape
        }
    }
    public void spawnBlockCords(int gridWidth) {
        //these 2 lines must be added b4 the x & y initialization of the block
        currRotation = new Random().nextInt(rotatedShapes.length); //everytime the shape spawns
        setShape(rotatedShapes[currRotation]);

        //which lets the blocks to spawn right above the grid
        x = new Random().nextInt(gridWidth-getBlockWidth());
        y = -getBlockHeight();
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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

    public int getRightBorder(){
        return x+getBlockWidth();
    }

    public int getLeftBorder(){
        return x;
    }
}
