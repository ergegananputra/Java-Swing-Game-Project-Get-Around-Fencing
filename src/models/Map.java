package models;

import information.FrameInfo;
import information.GameInfo;

import java.util.ArrayList;

public abstract class Map {
    //Atrributes
    private String name;

    private ArrayList<Obstacle> obstacles;
    private ArrayList<Soup> soups;

    public Player player1;
    public Player player2;


    // Constructor
    public Map(String mapName){
        obstacles = new ArrayList<>();
        soups = new ArrayList<>();
    }

    //Getter Setter
    // Name
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

    // obstacles
    public ArrayList<Obstacle> getObstacles() {
        // TODO: Edit!
        return obstacles;
    }

    public void addObstacles(Obstacle obstacle){
        obstacles.add(obstacle);
    }
    protected abstract void initializeObstacle();


    // soups
    public ArrayList<Soup> getSoups() {
        return soups;
    }

    public void addSoups(Soup soup){
        soups.add(soup);
    }


    // players
    public void addPlayers(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }


    // methods

    // reset map
    public void resetMap(){
        obstacles.clear();
        soups.clear();
        initializeObstacle();
    }

    // next player




    // Tiles Relative Coordinate
    public int getTilesRelativeCoorX(int tileIndex){
        return tileIndex * FrameInfo.tileSize + FrameInfo.arenaXstart;
    }

    public int getTilesRelativeCoorY(int tileIndex){
        return tileIndex * FrameInfo.tileSize + FrameInfo.arenaXstart;
    }


}
