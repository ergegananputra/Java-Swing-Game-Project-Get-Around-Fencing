package models;

import information.FrameInfo;
import information.GameInfo;

public class PlayerPhysic extends  Player implements IMoveable{

    // CONSTRUCTOR
    public PlayerPhysic(String outfit) {
        super(outfit);
    }



    // METHODS

    // Move
    @Override
    public void goUp() {
        if (!GameInfo.core.map.isObstacle(getCoordinateX(), getCoordinateY() - FrameInfo.tileSize)){
            decrementY(FrameInfo.tileSize);
        }
    }

    @Override
    public void goDown() {
        if (!GameInfo.core.map.isObstacle(getCoordinateX(), getCoordinateY() + FrameInfo.tileSize)){
            incrementY(FrameInfo.tileSize);
        }

    }

    @Override
    public void goLeft() {
        if (!GameInfo.core.map.isObstacle(getCoordinateX() - FrameInfo.tileSize, getCoordinateY())){
            decrementX(FrameInfo.tileSize);
        }

    }

    @Override
    public void goRight() {
        if (!GameInfo.core.map.isObstacle(getCoordinateX() + FrameInfo.tileSize, getCoordinateY())){
            incrementX(FrameInfo.tileSize);
        }

    }
}
