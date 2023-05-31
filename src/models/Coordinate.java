package models;

public abstract class Coordinate {
    //Attributes
    private int coordinateX;
    private int CoordinateY;

    //Getter Setter
    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return CoordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        CoordinateY = coordinateY;
    }
}
