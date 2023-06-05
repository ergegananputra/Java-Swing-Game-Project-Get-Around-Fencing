package models;

import information.FrameInfo;

public class Sheep extends PlayerPhysic{

    // ATTRIBUTES
    public static final String OUTFIT = "src/assets/characters/Sheep_"+ FrameInfo.tileSize +".png";



    // CONSTRUCTORS

    public Sheep(String name) {
        super(OUTFIT);
        setName(name);
    }

}
