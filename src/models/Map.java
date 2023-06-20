package models;

import GUI.GamePlayGUI;
import information.FrameInfo;
import information.GameInfo;

import java.util.ArrayList;

public abstract class Map {
    // ATTRIBUTES
    private String name;
    private final ArrayList<Obstacle> obstacles;
    private final ArrayList<Soup> soups;
    private final ArrayList<WitherRose> witherRoses;
    public Player player1;
    public Player player2;
    private boolean someOneStepWitherRose = false;



    // CONSTRUCTOR
    public Map(String mapName){
        setName(mapName);
        obstacles = new ArrayList<>();
        soups = new ArrayList<>();
        witherRoses = new ArrayList<>();
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

    // wither rose
    public abstract void generateRandomWitherRoses();

    public ArrayList<WitherRose> getWitherRoses(){
        return witherRoses;
    }

    public void addWitherRoses(WitherRose witherRose){
        witherRoses.add(witherRose);
    }

    public boolean isWitherRose(int x, int y){
        for (WitherRose witherRose : witherRoses) {
            if(witherRose.isOnWitherRose(x,y)){
                return true;
            }
        }
        return false;
    }

    public void checkStepForWitherRose(Player player){
        if(isWitherRose(player.getCoordinateX(), player.getCoordinateY())){
            someOneStepWitherRose = true;
            GameInfo.core.nextNowPlaying();
        }
    }

    public boolean getSomeOneStepWitherRose(){
        return someOneStepWitherRose;
    }

    // soups
    public abstract void generateRandomSoups();

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
                Soup returnSoup = soups.remove(index);
                GamePlayGUI.backgroundLabel.remove(returnSoup.soup);
                return returnSoup;
            }
        }
        return null;
    }

    public void checkStepForSoup(Player player){
        if(isSoup(player.getCoordinateX(), player.getCoordinateY())){
            Soup theSoup = getSoupFromCoordinate(
                    player.getCoordinateX(),
                    player.getCoordinateY()
            );
            player.setDefault_turns(theSoup.getEffect());
            theSoup.playSound();

        }
    }


    // players
    public void addPlayers(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }



    // METHODS


    // Tiles Relative Coordinate
    public int getTilesRelativeCoorX(int tileIndex){
        return tileIndex * FrameInfo.tileSize + FrameInfo.arenaXstart;
    }

    public int getTilesRelativeCoorY(int tileIndex){
        return tileIndex * FrameInfo.tileSize + FrameInfo.arenaYstart;
    }


}
