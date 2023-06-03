package models;
import information.FrameInfo;

import javax.swing.*;

public abstract class Player extends Coordinate implements IMoveable{

    //Attributes
    private String name;
    private int turns = 1;
    private int default_turns = turns;
    public final JLabel character;

    //Constructor
    public Player(String outfit){
        this.character = new JLabel(new ImageIcon(outfit));
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

    public int getTurns() {
        return turns;
    }

    public void decreaseTurns(int turns) {
        if(turns > 0){
            this.turns -= turns;
        }
    }
    public void setTurns(int turns){
        if(turns > 0){
            this.turns = turns;
        }
    }

    public void addTurns(int turns) {
        if(turns > 0){
            this.turns += turns;
            default_turns = this.turns;
        }
    }

    public int getDefault_turns(){
        return default_turns;
    }

    public void setInitialPosition(int x, int y){
        character.setBounds(x, y, FrameInfo.tileSize, FrameInfo.tileSize);
        setCoordinateX(x);
        setCoordinateY(y);
        updateLocation();
    }

    public void updateLocation(){
        character.setLocation(getCoordinateX(), getCoordinateY());
    }
}
