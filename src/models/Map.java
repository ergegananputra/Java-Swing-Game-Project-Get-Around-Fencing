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

    public int getArenaWidth() {
        return arenaWidth;
    }

    public void setArenaWidth(int arenaWidth) {
        this.arenaWidth = arenaWidth;
    }

    public int getArena() {
        return arena;
    }

    public void setArena(int arena) {
        this.arena = arena;
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

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
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
}
