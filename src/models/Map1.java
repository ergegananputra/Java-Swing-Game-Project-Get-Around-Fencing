package models;

import GUI.GamePlayGUI;
import information.FrameInfo;

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

    private final WitherRose[] outerWitherRosesPosition = {
            // left
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(0)),
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(1)),
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(2)),
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(3)),
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(4)),
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(5)),
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(6)),
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(7)),
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(8)),
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(9)),
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(10)),
            new WitherRose(getTilesRelativeCoorX(0), getTilesRelativeCoorY(11)),

            // right
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(0)),
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(1)),
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(2)),
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(3)),
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(4)),
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(5)),
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(6)),
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(7)),
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(8)),
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(9)),
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(10)),
            new WitherRose(getTilesRelativeCoorX(11), getTilesRelativeCoorY(11)),

            // top
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(0)),
            new WitherRose(getTilesRelativeCoorX(2), getTilesRelativeCoorY(0)),
            new WitherRose(getTilesRelativeCoorX(3), getTilesRelativeCoorY(0)),
            new WitherRose(getTilesRelativeCoorX(4), getTilesRelativeCoorY(0)),
            new WitherRose(getTilesRelativeCoorX(5), getTilesRelativeCoorY(0)),
            new WitherRose(getTilesRelativeCoorX(6), getTilesRelativeCoorY(0)),
            new WitherRose(getTilesRelativeCoorX(7), getTilesRelativeCoorY(0)),
            new WitherRose(getTilesRelativeCoorX(8), getTilesRelativeCoorY(0)),
            new WitherRose(getTilesRelativeCoorX(9), getTilesRelativeCoorY(0)),
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(0)),

            // bottom
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(11)),
            new WitherRose(getTilesRelativeCoorX(2), getTilesRelativeCoorY(11)),
            new WitherRose(getTilesRelativeCoorX(3), getTilesRelativeCoorY(11)),
            new WitherRose(getTilesRelativeCoorX(4), getTilesRelativeCoorY(11)),
            new WitherRose(getTilesRelativeCoorX(5), getTilesRelativeCoorY(11)),
            new WitherRose(getTilesRelativeCoorX(6), getTilesRelativeCoorY(11)),
            new WitherRose(getTilesRelativeCoorX(7), getTilesRelativeCoorY(11)),
            new WitherRose(getTilesRelativeCoorX(8), getTilesRelativeCoorY(11)),
            new WitherRose(getTilesRelativeCoorX(9), getTilesRelativeCoorY(11)),
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(11)),

    };

    private final WitherRose[] innerWitherRosesPosition = {
            // left
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(1)),
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(2)),
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(3)),
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(4)),
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(5)),
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(6)),
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(7)),
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(8)),
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(9)),
            new WitherRose(getTilesRelativeCoorX(1), getTilesRelativeCoorY(10)),

            // right
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(1)),
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(2)),
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(3)),
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(4)),
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(5)),
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(6)),
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(7)),
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(8)),
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(9)),
            new WitherRose(getTilesRelativeCoorX(10), getTilesRelativeCoorY(10)),

            // top
            new WitherRose(getTilesRelativeCoorX(2), getTilesRelativeCoorY(1)),
            new WitherRose(getTilesRelativeCoorX(3), getTilesRelativeCoorY(1)),
            new WitherRose(getTilesRelativeCoorX(4), getTilesRelativeCoorY(1)),
            new WitherRose(getTilesRelativeCoorX(5), getTilesRelativeCoorY(1)),
            new WitherRose(getTilesRelativeCoorX(6), getTilesRelativeCoorY(1)),
            new WitherRose(getTilesRelativeCoorX(7), getTilesRelativeCoorY(1)),
            new WitherRose(getTilesRelativeCoorX(8), getTilesRelativeCoorY(1)),
            new WitherRose(getTilesRelativeCoorX(9), getTilesRelativeCoorY(1)),

            // bottom
            new WitherRose(getTilesRelativeCoorX(2), getTilesRelativeCoorY(10)),
            new WitherRose(getTilesRelativeCoorX(3), getTilesRelativeCoorY(10)),
            new WitherRose(getTilesRelativeCoorX(4), getTilesRelativeCoorY(10)),
            new WitherRose(getTilesRelativeCoorX(5), getTilesRelativeCoorY(10)),
            new WitherRose(getTilesRelativeCoorX(6), getTilesRelativeCoorY(10)),
            new WitherRose(getTilesRelativeCoorX(7), getTilesRelativeCoorY(10)),
            new WitherRose(getTilesRelativeCoorX(8), getTilesRelativeCoorY(10)),
            new WitherRose(getTilesRelativeCoorX(9), getTilesRelativeCoorY(10)),

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



    // Generate Random Wither Roses
    @Override
    public void generateRandomWitherRoses() {
        if (getWitherRoses().size() < (FrameInfo.getArenaSize()/FrameInfo.tileSize - 1) * 4 ){
            ArrayList<WitherRose> availableRoses = new ArrayList<>(Arrays.asList(outerWitherRosesPosition));
            availableRoses.removeAll(getWitherRoses());
            if (!availableRoses.isEmpty()){
                int index = ThreadLocalRandom.current().nextInt(0, availableRoses.size());
                WitherRose witherRose = availableRoses.get(index);
                addWitherRoses(witherRose);
                GamePlayGUI.backgroundLabel.add(witherRose.rose);
            }
        } else {
            ArrayList<WitherRose> availableRoses = new ArrayList<>(Arrays.asList(innerWitherRosesPosition));
            availableRoses.removeAll(getWitherRoses());
            if (!availableRoses.isEmpty()){
                int index = ThreadLocalRandom.current().nextInt(0, availableRoses.size());
                WitherRose witherRose = availableRoses.get(index);
                addWitherRoses(witherRose);
                GamePlayGUI.backgroundLabel.add(witherRose.rose);
            }
        }
        GamePlayGUI.backgroundLabel.repaint();

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
