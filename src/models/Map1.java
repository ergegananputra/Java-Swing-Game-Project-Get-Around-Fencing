package models;

import information.FrameInfo;

public class Map1 extends Map{

    public Map1(String name){
        super(name);
        initializeObstacle();
    }

    protected final void initializeObstacle(){
        if (FrameInfo.getUserScreenSetting() > 1) {
            // Top
            addObstacles(new Obstacle(getTilesRelativeCoorX(5), getTilesRelativeCoorY(3)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(6), getTilesRelativeCoorY(3)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(7), getTilesRelativeCoorY(3)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(8), getTilesRelativeCoorY(3)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(9), getTilesRelativeCoorY(3)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(10), getTilesRelativeCoorY(3)));

            // Left
            addObstacles(new Obstacle(getTilesRelativeCoorX(3), getTilesRelativeCoorY(5)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(3), getTilesRelativeCoorY(6)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(3), getTilesRelativeCoorY(7)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(3), getTilesRelativeCoorY(8)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(3), getTilesRelativeCoorY(9)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(3), getTilesRelativeCoorY(10)));

            // Right
            addObstacles(new Obstacle(getTilesRelativeCoorX(12), getTilesRelativeCoorY(5)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(12), getTilesRelativeCoorY(6)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(12), getTilesRelativeCoorY(7)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(12), getTilesRelativeCoorY(8)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(12), getTilesRelativeCoorY(9)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(12), getTilesRelativeCoorY(10)));

            // Bottom
            addObstacles(new Obstacle(getTilesRelativeCoorX(5), getTilesRelativeCoorY(12)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(6), getTilesRelativeCoorY(12)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(7), getTilesRelativeCoorY(12)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(8), getTilesRelativeCoorY(12)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(9), getTilesRelativeCoorY(12)));
            addObstacles(new Obstacle(getTilesRelativeCoorX(10), getTilesRelativeCoorY(12)));
        }
    }
}
