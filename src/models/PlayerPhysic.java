package models;
import information.FrameInfo;
import information.GameInfo;

public class PlayerPhysic extends  Player implements IMoveable{

    public PlayerPhysic(String outfit) {
        super(outfit);
    }


    // Move
    @Override
    public void goUp() {
        //TODO: naik
        if (!GameInfo.core.map.isObstacle(getCoordinateX(), getCoordinateY() - FrameInfo.tileSize)){
            decrementY(FrameInfo.tileSize);
        }
    }

    @Override
    public void goDown() {
        //TODO: turun
        if (!GameInfo.core.map.isObstacle(getCoordinateX(), getCoordinateY() + FrameInfo.tileSize)){
            incrementY(FrameInfo.tileSize);
        }

    }

    @Override
    public void goLeft() {
        //TODO: kiri
        if (!GameInfo.core.map.isObstacle(getCoordinateX() - FrameInfo.tileSize, getCoordinateY())){
            decrementtX(FrameInfo.tileSize);
        }

    }

    @Override
    public void goRight() {
        //TODO: kanan
        if (!GameInfo.core.map.isObstacle(getCoordinateX() + FrameInfo.tileSize, getCoordinateY())){
            incrementX(FrameInfo.tileSize);
        }

    }
}
