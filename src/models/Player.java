package models;
import GUI.GamePlayGUI;
import information.FrameInfo;
import information.SoundInfo;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public abstract class Player extends Coordinate implements IMoveable{

    // ATTRIBUTES
    private String name;
    private int turns = 1;
    private int default_turns = turns;
    public final JLabel character;
    public JPanel playerInfoPanel;
    public JLabel turnLabel;
    private final JLabel icon;
    protected final GameSound sounds;



    // CONSTRUCTORS
    public Player(String outfit){
        this.character = new JLabel(new ImageIcon(outfit));
        this.icon = new JLabel(new ImageIcon(outfit));
        this.sounds = new GameSound();
        this.sounds.setFootSteps();
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
    public void createPanel() {
        // Load External Font
        Font minecraftFont = null;
        try {
            minecraftFont = Font.createFont(Font.TRUETYPE_FONT, FrameInfo.fontFile);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        assert minecraftFont != null;
        Font minecraftFontHeader = minecraftFont.deriveFont(Font.PLAIN, 30);
        Font minecraftInfoTitleText = minecraftFont.deriveFont(Font.PLAIN, 18);
        Font minecraftTurnLabel = minecraftFont.deriveFont(Font.PLAIN, 50);

        // Panel Player
        playerInfoPanel = new JPanel(new FlowLayout());
        if (getCoordinateX() < FrameInfo.frameWidth/2){
            playerInfoPanel.setBounds(50, 75, 150, 200);
        } else {
            playerInfoPanel.setBounds(FrameInfo.frameWidth - 200, 75, 150, 200);
        }

        ImageIcon panelBackground = new ImageIcon("src/assets/panel/PlayerInfoPanel.png");
        JLabel panelLabel = new JLabel(panelBackground);
        panelLabel.setLayout(new FlowLayout());
        GamePlayGUI.backgroundLabel.add(playerInfoPanel);
        playerInfoPanel.add(panelLabel);

        JLabel divider = new JLabel();
        divider.setPreferredSize(new Dimension(playerInfoPanel.getWidth(), 5));
        divider.setOpaque(true);
        divider.setBackground(new Color(0, 0, 0, 0));
        panelLabel.add(divider);

        panelLabel.add(icon);

        JLabel divider_2 = new JLabel();
        divider_2.setPreferredSize(new Dimension(playerInfoPanel.getWidth(), 5));
        divider_2.setOpaque(true);
        divider_2.setBackground(new Color(0, 0, 0, 0));
        panelLabel.add(divider_2);



        JLabel playerHeader = new JLabel(name);
        playerHeader.setFont(minecraftFontHeader);
        playerHeader.setForeground(Color.WHITE);
        panelLabel.add(playerHeader);

        JLabel playerInfoTitleText = new JLabel("Available Turns");
        playerInfoTitleText.setFont(minecraftInfoTitleText);
        playerInfoTitleText.setForeground(Color.WHITE);
        panelLabel.add(playerInfoTitleText);

        turnLabel = new JLabel(Integer.toString(turns));
        turnLabel.setFont(minecraftTurnLabel);
        turnLabel.setForeground(Color.WHITE);
        panelLabel.add(turnLabel);
    }

    public void updatePlayerTurnLabel(){
        turnLabel.setText(Integer.toString(turns));
    }

}
