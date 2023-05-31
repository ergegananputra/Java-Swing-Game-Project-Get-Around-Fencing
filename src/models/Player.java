package models;

public abstract class Player extends Coordinate implements IMoveable{

    //Attributes
    private String name;
    private String outfit;
    private int turns;

    //Constructor
    public Player(String outfit){
        this.outfit = outfit;
    }

    //Getter Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutfit() {
        return outfit;
    }

    public void setOutfit(String outfit) {
        this.outfit = outfit;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }
}
