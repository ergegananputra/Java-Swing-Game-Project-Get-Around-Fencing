package models;

import information.FrameInfo;
import java.util.ArrayList;

public abstract class Map {
    // ATTRIBUTES
    private String name;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Soup> soups;
    public Player player1;
    public Player player2;



    // CONSTRUCTOR
    public Map(String mapName){
        obstacles = new ArrayList<>();
        soups = new ArrayList<>();
        initializeObstacle();
    }



    // GETTER-SETTER


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
    public boolean isObstacle(int x, int y){
        for (Obstacle obstacle : obstacles) {
            if(obstacle.isOnObstacle(x,y)){
                return true;
            }
        }
        return false;
    }

    protected abstract void initializeObstacle();
    public abstract void generateRandomSoups();


    // soups
    public ArrayList<Soup> getSoups() {
        return soups;
    }

    public void addSoups(Soup soup){
        soups.add(soup);
    }

    public boolean isSoup(int x, int y){
        for (Soup soup : soups) {
            if(soup.isOnSoup(x,y)){
                return true;
            }
        }
        return false;
    }

    public Soup getSoupFromCoordinate(int x, int y){
        for (Soup soup : soups) {
            if (soup.getCoordinateX() == x && soup.getCoordinateY() == y){
                int index = soups.indexOf(soup);
                return soups.remove(index);
            }
        }
        return null;
    }


    // players
    public void addPlayers(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }



    // METHODS


    // reset map
    public void resetMap(){
        obstacles.clear();
        soups.clear();
        initializeObstacle();
    }


    // Tiles Relative Coordinate
    public int getTilesRelativeCoorX(int tileIndex){
        return tileIndex * FrameInfo.tileSize + FrameInfo.arenaXstart;
    }

    public int getTilesRelativeCoorY(int tileIndex){
        return tileIndex * FrameInfo.tileSize + FrameInfo.arenaYstart;
    }


}
