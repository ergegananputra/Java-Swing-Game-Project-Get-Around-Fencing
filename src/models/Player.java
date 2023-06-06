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
    public JLabel turnLabel;



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
        createPanel();
    }


    // update location
    public void updateLocation(){
        character.setLocation(getCoordinateX(), getCoordinateY());
    }


    // create panel
    public void createPanel(){
        // Panel Player 1
        playerInfoPanel = new JPanel(new FlowLayout());
        if (getCoordinateX() < FrameInfo.frameWidth/2){
            playerInfoPanel.setBounds(0, 75, 150, 200);
        } else {
            playerInfoPanel.setBounds(FrameInfo.frameWidth - 150, 75, 150, 200);
        }

        playerInfoPanel.setBackground(Color.CYAN);
        playerInfoPanel.setOpaque(true);
        GamePlayGUI.backgroundLabel.add(playerInfoPanel);

        JLabel player1Header = new JLabel(name);
        player1Header.setFont(new Font(FrameInfo.fontPath, Font.BOLD, 30));
        player1Header.setForeground(Color.BLACK);
        playerInfoPanel.add(player1Header);

        JLabel player1InfoTitleText = new JLabel("Available Turns");
        player1InfoTitleText.setFont(new Font(FrameInfo.fontPath, Font.TRUETYPE_FONT, 18));
        player1InfoTitleText.setForeground(Color.BLACK);
        playerInfoPanel.add(player1InfoTitleText);

        turnLabel = new JLabel(Integer.toString(turns));
        turnLabel.setFont(new Font(FrameInfo.fontPath, Font.TRUETYPE_FONT, 50));
        playerInfoPanel.add(turnLabel);
    }

    public void updatePlayerTurnLabel(){
        turnLabel.setText(Integer.toString(turns));
    }

}
