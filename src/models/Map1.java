package models;

import information.FrameInfo;

public class Map1 extends Map{

    public Map1(String name){
        super(name);
    }

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
}
