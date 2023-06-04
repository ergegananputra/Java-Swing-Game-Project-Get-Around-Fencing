package models;

import information.FrameInfo;

public class Obstacle extends Coordinate{

    public boolean isOnObstacle(int x, int y) {
        return super.getCoordinateX() == x && super.getCoordinateY() == y;
    }

    // Constructor
    public Obstacle(int x, int y){
        setCoordinateX(x);
        setCoordinateY(y);
    }
}
