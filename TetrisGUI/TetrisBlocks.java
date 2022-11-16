package TetrisGUI;

import java.awt.*;

public class TetrisBlocks {
    private int[][] shape;
    private Color color;
    private int x,y;

    public TetrisBlocks(int[][] shape, Color color){
        setShape(shape);
        setColor(color);
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



    public int getBlockHeight(){
        return getShape().length;
    }

    public int getBlockWidth(){
        return getShape()[0].length;
    }
}
