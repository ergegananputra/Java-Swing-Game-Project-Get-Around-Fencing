package models;

import information.FrameInfo;

import java.util.ArrayList;

public abstract class Map {
    //Atrributes
    private String name;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Soup> soups;
    protected ArrayList<Player> players;

    // Constructor
    public Map(String mapName){
        obstacles = new ArrayList<>();
        soups = new ArrayList<>();
        players = new ArrayList<>();
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



    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(ArrayList<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public ArrayList<Soup> getSoups() {
        return soups;
    }

    public void setSoups(ArrayList<Soup> soups) {
        this.soups = soups;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayers(Player player) {
        players.add(player);
    }

    public void addObstacles(Obstacle obstacle){
        obstacles.add(obstacle);
    }

    public void addSoups(Soup soup){
        soups.add(soup);
    }

    public void resetMap(){
        //TODO: Belum jadi
    }

    public boolean isGameEnd(){
        //TODO: Belum jadi
        return false;
    }

    public Player nextPlayer(){
        //TODO: Belum jadi
        return new Spider();
    }

    public int getTilesRelativeCoorX(int tileIndex){
        return tileIndex * FrameInfo.tileSize + FrameInfo.arenaXstart;
    }

    public int getTilesRelativeCoorY(int tileIndex){
        return tileIndex * FrameInfo.tileSize + FrameInfo.arenaXstart;
    }
}
