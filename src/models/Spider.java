package models;

import information.FrameInfo;

public class Spider extends Player{
    public static final String OUTFIT = "src/assets/characters/Spider.png";

    public Spider() {
        super(OUTFIT);
    }


    @Override
    public void goUp() {
        //TODO: naik
        decrementY(FrameInfo.tileSize);
    }

    @Override
    public void goDown() {
        //TODO: turun
        incrementY(FrameInfo.tileSize);
    }

    @Override
    public void goLeft() {
        //TODO: kiri
        decrementtX(FrameInfo.tileSize);
    }

    @Override
    public void goRight() {
        //TODO: kanan
        incrementX(FrameInfo.tileSize);
    }
}
