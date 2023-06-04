package models;

import information.FrameInfo;

public class Obstacle extends Coordinate{


    // CONSTRUCTORS
    public Obstacle(int x, int y){
        setCoordinateX(x);
        setCoordinateY(y);
    }



    // METHODS

    // IS ON OBSTACLE
    public boolean isOnObstacle(int x, int y) {
        return super.getCoordinateX() == x && super.getCoordinateY() == y;
    }
}
