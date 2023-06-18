package models;

import information.FrameInfo;
import information.GameInfo;
import information.SoundInfo;

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
            SoundInfo.playRandomFootstep();
        }
    }

    @Override
    public void goDown() {
        if (!GameInfo.core.map.isObstacle(getCoordinateX(), getCoordinateY() + FrameInfo.tileSize)){
            incrementY(FrameInfo.tileSize);
            SoundInfo.playRandomFootstep();
        }
    }

    @Override
    public void goLeft() {
        if (!GameInfo.core.map.isObstacle(getCoordinateX() - FrameInfo.tileSize, getCoordinateY())){
            decrementX(FrameInfo.tileSize);
            SoundInfo.playRandomFootstep();
        }
    }

    @Override
    public void goRight() {
        if (!GameInfo.core.map.isObstacle(getCoordinateX() + FrameInfo.tileSize, getCoordinateY())){
            incrementX(FrameInfo.tileSize);
            SoundInfo.playRandomFootstep();
        }
    }
}
