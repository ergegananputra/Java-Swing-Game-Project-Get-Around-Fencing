package models;

import GUI.GamePlayGUI;
import information.GameInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Map1 extends Map{
    // ATTRIBUTES
    private final Soup[] soupsPosition = {
            new Soup("Beetroots_1", 1, getTilesRelativeCoorX(4), getTilesRelativeCoorY(4)),
            new Soup("Beetroots_2", 1, getTilesRelativeCoorX(7), getTilesRelativeCoorY(7)),
            new Soup("Beetroots_3", 1, getTilesRelativeCoorX(7), getTilesRelativeCoorY(4)),
            new Soup("Beetroots_4", 1, getTilesRelativeCoorX(4), getTilesRelativeCoorY(7)),
            new Soup("Beetroots_5", 1, getTilesRelativeCoorX(5), getTilesRelativeCoorY(6)),
            new Soup("Beetroots_6", 1, getTilesRelativeCoorX(6), getTilesRelativeCoorY(5)),
            new Soup("Beetroots_7", 1, getTilesRelativeCoorX(6), getTilesRelativeCoorY(6)),
            new Soup("Beetroots_8", 1, getTilesRelativeCoorX(5), getTilesRelativeCoorY(5)),
    };



    // CONSTRUCTORS
    public Map1(String name){
        super(name);
    }



    // METHODS


    // INITIALIZE OBSTACLE

    @Override
    protected final void initializeObstacle(){
        // Top
        addObstacles(new Obstacle(getTilesRelativeCoorX(4), getTilesRelativeCoorY(2)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(5), getTilesRelativeCoorY(2)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(6), getTilesRelativeCoorY(2)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(7), getTilesRelativeCoorY(2)));


        // Left
        addObstacles(new Obstacle(getTilesRelativeCoorX(2), getTilesRelativeCoorY(4)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(2), getTilesRelativeCoorY(5)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(2), getTilesRelativeCoorY(6)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(2), getTilesRelativeCoorY(7)));

        // Right
        addObstacles(new Obstacle(getTilesRelativeCoorX(9), getTilesRelativeCoorY(4)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(9), getTilesRelativeCoorY(5)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(9), getTilesRelativeCoorY(6)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(9), getTilesRelativeCoorY(7)));

        // Bottom
        addObstacles(new Obstacle(getTilesRelativeCoorX(4), getTilesRelativeCoorY(9)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(5), getTilesRelativeCoorY(9)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(6), getTilesRelativeCoorY(9)));
        addObstacles(new Obstacle(getTilesRelativeCoorX(7), getTilesRelativeCoorY(9)));

    }


    // Generate Random soup

    @Override
    public void generateRandomSoups() {
        ArrayList<Soup> availableSoups = new ArrayList<>(Arrays.asList(soupsPosition));
        availableSoups.removeAll(getSoups());

        if (!availableSoups.isEmpty()) {
            int index = ThreadLocalRandom.current().nextInt(0, availableSoups.size());
            Soup soup = availableSoups.get(index);
            addSoups(soup);
            GamePlayGUI.backgroundLabel.add(soup.soup);
        }
        GamePlayGUI.backgroundLabel.repaint();
    }
}
