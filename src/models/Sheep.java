package models;

public class Sheep extends PlayerPhysic{
    public static final String OUTFIT = "src/assets/characters/Chicken.png";

    public Sheep(String name) {
        super(OUTFIT);
        setName(name);
    }

}
