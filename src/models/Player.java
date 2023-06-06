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
        setInfoPanel(0);
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

    // set info panel
    public void setInfoPanel(int turns){
        playerInfoPanel = new JPanel(new FlowLayout());
        playerInfoPanel.setBounds(0, 75, 150, 200);
        playerInfoPanel.setOpaque(false);
        GamePlayGUI.backgroundLabel.add(playerInfoPanel);

        JLabel player1Header = new JLabel(name);
        player1Header.setFont(new Font("Minecraft", Font.BOLD, 30));
        player1Header.setForeground(Color.BLACK);
        playerInfoPanel.add(player1Header);

        JLabel player1InfoTitleText = new JLabel("Available Turns");
        player1InfoTitleText.setFont(new Font("Minecraft", Font.TRUETYPE_FONT, 18));
        player1InfoTitleText.setForeground(Color.BLACK);
        playerInfoPanel.add(player1InfoTitleText);

        turnJLabel = new JLabel(String.valueOf(turns));
        turnJLabel.setFont(new Font("Minecraft", Font.TRUETYPE_FONT, 110));
        turnJLabel.setForeground(Color.BLACK);
        playerInfoPanel.add(turnJLabel);
        this.turnJLabel = new JLabel();
    }

    // update info panel
    public void updateInfoPanel(){
        GamePlayGUI.backgroundLabel.remove(playerInfoPanel);
        setInfoPanel(getTurns());
        GamePlayGUI.backgroundLabel.add(playerInfoPanel);
    };


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
