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
        if (GameInfo.core.map.isSoup(getCoordinateX(), getCoordinateY())){
            setDefault_turns(GameInfo.core.map.getSoupFromCoordinate(getCoordinateX(),getCoordinateY()).getEffect());
        }
    }

    @Override
    public void goDown() {
        if (!GameInfo.core.map.isObstacle(getCoordinateX(), getCoordinateY() + FrameInfo.tileSize)){
            incrementY(FrameInfo.tileSize);
        }
        if (GameInfo.core.map.isSoup(getCoordinateX(), getCoordinateY())){
            setDefault_turns(GameInfo.core.map.getSoupFromCoordinate(getCoordinateX(),getCoordinateY()).getEffect());
        }

    }

    @Override
    public void goLeft() {
        if (!GameInfo.core.map.isObstacle(getCoordinateX() - FrameInfo.tileSize, getCoordinateY())){
            decrementX(FrameInfo.tileSize);
        }
        if (GameInfo.core.map.isSoup(getCoordinateX(), getCoordinateY())){
            setDefault_turns(GameInfo.core.map.getSoupFromCoordinate(getCoordinateX(),getCoordinateY()).getEffect());
        }

    }

    @Override
    public void goRight() {
        if (!GameInfo.core.map.isObstacle(getCoordinateX() + FrameInfo.tileSize, getCoordinateY())){
            incrementX(FrameInfo.tileSize);
        }
        if (GameInfo.core.map.isSoup(getCoordinateX(), getCoordinateY())){
            setDefault_turns(GameInfo.core.map.getSoupFromCoordinate(getCoordinateX(),getCoordinateY()).getEffect());
        }

    }
}
