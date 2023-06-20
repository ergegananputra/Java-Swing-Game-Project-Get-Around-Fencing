package information;

import core.Engine;


public class GameInfo {
    public static boolean isGameEnd = false;
    public static int moves = 0;
    public static Engine core;
    private final static SoundInfo gameSound = new SoundInfo();


    public static void restart(Engine core){
        isGameEnd = false;
        moves = 0;
        GameInfo.core = core;
    }

    public static void setBackgroundMusic(){
        SoundInfo.setBackgroundMusic(1, 0.25f);
    }

    public static void setBackgroundMusic(int select, float volume){
        SoundInfo.setBackgroundMusic(select, volume);
    }

    public static void playBackgroundMusic(){
        gameSound.playBackgroundMusic();
    }

    public static void stopBackgroundMusic(){
        gameSound.stopBackgroundMusic();
    }


}
