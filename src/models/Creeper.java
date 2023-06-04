package models;

public class Creeper extends PlayerPhysic{
    // ATTRIBUTES
    public static final String OUTFIT = "src/assets/characters/Creeper.png";



    // CONSTRUCTORS
    public Creeper(String name) {
        super(OUTFIT);
        setName(name);
    }

}
