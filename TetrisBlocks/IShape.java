package TetrisBlocks;

import GUI.Blocks;

import java.awt.*;

public class IShape extends Blocks {
    public IShape() {
        super(new int[][]{{1,1,1,1}},new Color(145, 134, 126));
    }

    public void rotate(){ //makes rotation better
        super.rotate();

        if(this.getBlockWidth() == 1){
            this.setX(this.getX()+1);
            this.setY(this.getY()-1);
        }
        else{
            this.setX(this.getX()-1);
            this.setY(this.getY()+1);
        }
    }
}