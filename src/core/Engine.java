package core;

import GUI.GameEndGUI;
import GUI.GamePlayGUI;
import information.FrameInfo;
import information.GameInfo;
import models.Map;
import models.Map1;
import models.Player;
import java.util.logging.Logger;


public class Engine {
    // Developer
    private static final Logger LOGGER = Logger.getLogger(GamePlayGUI.class.getName());

    // Atributes
    public Map map;
    private int nowPlaying = 1; // start from 1
    public static GamePlayGUI gamePlayGUI;

    // Getter n Setter

    // now Playing
    public int getNowPlaying() {
        return nowPlaying;
    }

    public void nextNowPlaying(){
        if (getPlayer1().getTurns() <= 0 || getPlayer2().getTurns() <= 0){
            if (!GameInfo.isGameEnd) {
                if (nowPlaying == 2 && getPlayer2().getTurns() <= 0) {
                    nowPlaying = 1;
                    getPlayer1().setTurns(getPlayer1().getDefault_turns());
                    GameInfo.core.getPlayer1().updatePlayerTurnLabel();
                    GameInfo.moves++;
                    generateRandomSoup();

                } else if (nowPlaying == 1 && getPlayer1().getTurns() <= 0) {
                    nowPlaying = 2;
                    getPlayer2().setTurns(getPlayer2().getDefault_turns());
                    GameInfo.core.getPlayer2().updatePlayerTurnLabel();
                    GameInfo.moves++;
                    generateRandomSoup();
                }


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

    public void checkIsThereAWinner(){
        if (getPlayer1().getCoordinateX() == getPlayer2().getCoordinateX()
                && getPlayer1().getCoordinateY() == getPlayer2().getCoordinateY()){
            GameInfo.isGameEnd = true;

            // TODO: Delete sout if GUI already implemented!
            if (nowPlaying == 1){
                // TODO : ini nanti dimasukkan ke start
                Engine newCore = new Engine();
                Map newMap1 = new Map1("New Game");
                newCore.setMap(newMap1);
                GameInfo.restart(newCore);

                Engine.gamePlayGUI.dispose();
                new GameEndGUI(FrameInfo.getUserScreenSetting(), GamePlayGUI.debugMode, map.player1);


                System.out.println(map.player1.getName() + " Win !");
                GamePlayGUI.backgroundLabel.remove(getPlayer2().character);
            } else {
                // TODO : ini nanti dimasukkan ke start
                Engine newCore = new Engine();
                Map newMap1 = new Map1("New Game");
                newCore.setMap(newMap1);
                GameInfo.restart(newCore);

                Engine.gamePlayGUI.dispose();
                new GameEndGUI(FrameInfo.getUserScreenSetting(), GamePlayGUI.debugMode, map.player2);


                System.out.println(map.player2.getName() + " Win !");
                GamePlayGUI.backgroundLabel.remove(getPlayer1().character);
            }

        }
    }

    private void generateRandomSoup(){
        if (GameInfo.moves % 20 == 0) {
            map.generateRandomSoups();
        }
    }

}
