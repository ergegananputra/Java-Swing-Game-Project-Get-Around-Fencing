package models;

import information.FrameInfo;

import javax.swing.*;

public class WitherRose extends Coordinate{
    // ATTRIBUTES
    public static final String OUTFIT = "src/assets/wither_rose/wither_rose_"+ FrameInfo.tileSize +".png";
    public final JLabel rose;



    // CONSTRUCTORS
    public WitherRose(int x, int y){
        rose = new JLabel(new ImageIcon(OUTFIT));
        rose.setBounds(x, y, FrameInfo.tileSize, FrameInfo.tileSize);
        setCoordinateX(x);
        setCoordinateY(y);
    }



    // METHODS

    // is on wither rose
    public boolean isOnWitherRose(int x, int y) {
        return super.getCoordinateX() == x && super.getCoordinateY() == y;
    }
}
