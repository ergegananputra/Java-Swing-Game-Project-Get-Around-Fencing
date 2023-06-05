package models;

import information.FrameInfo;

public class Spider extends PlayerPhysic{

    // ATTRIBUTES

    public static final String OUTFIT = "src/assets/characters/spider/Spider_"+ FrameInfo.tileSize +".png";



    // CONSTRUCTORS

    public Spider(String name) {
        super(OUTFIT);
        setName(name);
    }


}
