package models;

public class Creeper extends PlayerPhysic{
    public static final String OUTFIT = "src/assets/characters/Creeper.png";

    public Creeper(String name) {
        super(OUTFIT);
        setName(name);
    }

}
