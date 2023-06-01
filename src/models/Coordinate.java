package models;

import GUI.FrameInfo;

public abstract class Coordinate {
    //Attributes
    private int coordinateX;
    private int coordinateY;

    //Getter Setter
    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void incrementX(int value){
        if (value > 0 && coordinateX + value <= FrameInfo.arenaXend){
            coordinateX += value;
        }
    }

    public void incrementY(int value){
        if (value > 0  && coordinateY + value <= FrameInfo.arenaYend){
            coordinateY += value;
        }
    }

    public void decrementtX(int value){
        if (value > 0  && coordinateX - value >= FrameInfo.arenaXstart){
            coordinateX -= value;
        }
    }

    public void decrementY(int value){
        if (value > 0 && coordinateY - value >= FrameInfo.arenaYstart){
            coordinateY -= value;
        }
    }
}
