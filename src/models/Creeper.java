package models;

import information.FrameInfo;

public class Creeper extends PlayerPhysic{
    // ATTRIBUTES
    public static final String OUTFIT = "src/assets/characters/Creeper_"+FrameInfo.tileSize +".png" ;



    // CONSTRUCTORS
    public Creeper(String name) {
        super(OUTFIT);
        setName(name);
    }

}
