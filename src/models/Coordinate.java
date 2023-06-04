package models;

import information.FrameInfo;

public abstract class Coordinate {
    // ATTRIBUTES
    private int coordinateX;
    private int coordinateY;



    // GETTER-SETTER


    // COORDINATE X
    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }


    // COORDINATE Y

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }



    // METHODS

    // MANIPULATION X

    public void incrementX(int value){
        if (value > 0 && coordinateX + value < FrameInfo.arenaXend){
            coordinateX += value;
        }
    }

    public void decrementX(int value){
        if (value > 0  && coordinateX - value >= FrameInfo.arenaXstart){
            coordinateX -= value;
        }
    }


    // MANIPULATION Y

    public void incrementY(int value){
        if (value > 0  && coordinateY + value < FrameInfo.arenaYend){
            coordinateY += value;
        }
    }

    public void decrementY(int value){
        if (value > 0 && coordinateY - value >= FrameInfo.arenaYstart){
            coordinateY -= value;
        }
    }
}
