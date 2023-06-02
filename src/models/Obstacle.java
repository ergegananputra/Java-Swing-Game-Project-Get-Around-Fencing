package models;

public class Obstacle extends Coordinate{

    public boolean isObstacle(int x, int y) {
        return super.getCoordinateX() == x && super.getCoordinateY() == y;
    }

    // Constructor
    public Obstacle(int x, int y){
        setCoordinateX(x);
        setCoordinateY(y);
    }
}
