package information;

import core.Engine;
import models.Soup;

public class GameInfo {
    public static boolean isGameEnd = false;
    public static int moves = 0;
    public static int turnsP1 = 0;
    public static int turnsP2 = 0;
    public static Engine core;


    public static void playerTurnsUpdate(){}
    public static void restart(Engine core){
        isGameEnd = false;
        moves = 0;
        GameInfo.core = core;
    }


}
