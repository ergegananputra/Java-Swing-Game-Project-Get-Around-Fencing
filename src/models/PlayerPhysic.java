package models;
import information.FrameInfo;

public class PlayerPhysic extends  Player implements IMoveable{

    public PlayerPhysic(String outfit) {
        super(outfit);
    }


    // Move
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
