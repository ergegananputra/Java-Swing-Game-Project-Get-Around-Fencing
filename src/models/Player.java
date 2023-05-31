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
        if(!name.isEmpty()){
            this.name = name;
        }
        else {
            this.name = "No Name";
        }
    }

    public String getOutfit() {
        return outfit;
    }

    public int getTurns() {
        return turns;
    }

    public void decreaseTurns(int turns) {
        if(turns > 0){
            this.turns -= turns;
        }
    }

    public void addTurns(int turns) {
        if(turns > 0){
            this.turns += turns;
        }
    }
}
