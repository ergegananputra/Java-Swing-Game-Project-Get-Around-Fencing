package models;

public class Soup extends Coordinate{
    private String name;
    private int effect;
    public static final String OUTFIT = "";

    public Soup(String name, int effect) {
        setName(name);
        setEffect(effect);
    }

    public boolean isSoup(int x, int y) {
        return super.getCoordinateX() == x && super.getCoordinateY() == y;
    }

    // Getter Setter
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

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        if (effect > 0) {
            this.effect = effect;
        }
    }

    public static String getOutfit() {
        return OUTFIT;
    }
}
