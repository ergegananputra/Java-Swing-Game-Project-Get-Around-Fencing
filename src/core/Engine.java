package core;

import GUI.GamePlayGUI;
import information.GameInfo;
import models.Map;
import models.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Engine {
    // Developer
    private static final Logger LOGGER = Logger.getLogger(GamePlayGUI.class.getName());

    // Atributes
    public Map map;
    private int nowPlaying = 1; // start from 1

    // Getter n Setter

    // now Playing


    public int getNowPlaying() {
        return nowPlaying;
    }

    public void nextNowPlaying(){
        if (getPlayer1().getTurns() <= 0 || getPlayer2().getTurns() <= 0){
            GameInfo.moves++;
            if (!GameInfo.isGameEnd) {
                if (nowPlaying == 2 && getPlayer2().getTurns() <= 0) {
                    nowPlaying = 1;
                    getPlayer1().setTurns(getPlayer1().getDefault_turns());
                } else if (nowPlaying == 1 && getPlayer1().getTurns() <= 0) {
                   nowPlaying = 2;
                    getPlayer2().setTurns(getPlayer2().getDefault_turns());
                }
            } else {
                nowPlaying = 0;
            }
        }
    }

    // Methods
    public Player getPlayer1() {
        return map.player1;
    }
    public Player getPlayer2() {
        return map.player2;
    }
    /**
     * Cara pakai. Di button, nanti dihubungkan dengan method setMap.
     * Contoh:
     * Button 1 : akan dihubungkan dengan Map1,
     * sehingga dibuat demikian
     * xxx.setMap(objek_dengan_kelas_map1)
     *
     *
     * WARNING!
     * pastikan map tersebut telah diinisiasi dengan:
     * - initializeObstacle()
     * agar daerah terlarang(obstacle) muncul sebagai
     * constraint
    */
    public void setMap(Map map){
        this.map = map;
    }



}
