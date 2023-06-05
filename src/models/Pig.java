package models;

import information.FrameInfo;

public class Pig extends PlayerPhysic{
    // ATTRIBUTES
    public static final String OUTFIT = "src/assets/characters/pig/Pig_"+ FrameInfo.tileSize +".png";



    // CONSTRUCTORS
    public Pig(String name) {
        super(OUTFIT);
        setName(name);
    }


}
