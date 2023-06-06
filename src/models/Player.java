package models;
import GUI.GamePlayGUI;
import information.FrameInfo;
import information.GameInfo;

import javax.swing.*;
import java.awt.*;

public abstract class Player extends Coordinate implements IMoveable{

    // ATTRIBUTES
    private String name;
    private int turns = 1;
    private int default_turns = turns;
    public final JLabel character;
    public JPanel playerInfoPanel;
    public JLabel turnJLabel;



    // CONSTRUCTORS
    public Player(String outfit){
        this.character = new JLabel(new ImageIcon(outfit));
    }



    // GETTER-SETTER

    // name

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


    // turns

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


    // default turns

    public int getDefault_turns(){
        return default_turns;
    }

    public void setDefault_turns(int x){
        default_turns += x;
    }



    // METHODS

    // set initial position

    public void setInitialPosition(int x, int y){
        character.setBounds(x, y, FrameInfo.tileSize, FrameInfo.tileSize);
        setCoordinateX(x);
        setCoordinateY(y);
        updateLocation();
    }


    // update location
    public void updateLocation(){
        character.setLocation(getCoordinateX(), getCoordinateY());
    }

}
