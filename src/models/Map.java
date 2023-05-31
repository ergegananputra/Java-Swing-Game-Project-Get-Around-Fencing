package models;

import java.util.ArrayList;

public abstract class Map {
    //Atrributes
    private String name;
    private int arenaWidth;
    private int arena;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Soup> soups;
    protected ArrayList<Player> players;
}
