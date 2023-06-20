package models;

import information.FrameInfo;

import javax.swing.*;

public class Soup extends Coordinate{

    // ATTRIBUTES

    private String name;
    private int effect;
    public static final String OUTFIT = "src/assets/soups/soup_"+ FrameInfo.tileSize +".png";
    public final JLabel soup;

    private final GameSound sounds;



    // CONSTRUCTORS

    public Soup(String name, int effect, int x, int y) {
        setName(name);
        setEffect(effect);
        soup = new JLabel(new ImageIcon(OUTFIT));
        soup.setBounds(x, y, FrameInfo.tileSize, FrameInfo.tileSize);
        setCoordinateX(x);
        setCoordinateY(y);

        sounds = new GameSound();
        sounds.setEatSfx();
    }



    // Getter Setter

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


    // effect
    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        if (effect > 0) {
            this.effect = effect;
        }
    }



    // METHODS

    // is on soup
    public boolean isOnSoup(int x, int y) {
        return super.getCoordinateX() == x && super.getCoordinateY() == y;
    }

    void playSound(){
        sounds.playEatSfx();
    }
}
