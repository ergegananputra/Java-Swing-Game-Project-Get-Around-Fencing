package GUI;
import core.Engine;
import information.FrameInfo;
import information.GameInfo;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;

public class GamePlayGUI extends JFrame {
    // Developer Atributes
    private static final Logger LOGGER = Logger.getLogger(GamePlayGUI.class.getName());
    public  static boolean debugMode;


    // Attributes
    public static JLabel backgroundLabel;
    private Map map;



    // Constructor
    public GamePlayGUI(int preset, boolean degbugMode, int player1Character, int player2Character) {
        GamePlayGUI.debugMode = degbugMode;

        // Set User Screen Setting Preference
        FrameInfo.setUserScreenSetting(preset);
        FrameInfo.refresh();

        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameInfo.frameWidth+16, FrameInfo.frameHeight + 40);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create the main content panel with a BorderLayout
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.BLACK); // Set the background color of the content pane

        // Create a nested panel for background image with a BorderLayout
        JPanel backgroundPanel = new JPanel(new BorderLayout());
        backgroundPanel.setBackground(Color.BLACK);

        // Initialize Background Label
        ImageIcon backgroundImage = new ImageIcon(FrameInfo.background);
        backgroundLabel = new JLabel(backgroundImage);

        // Add the background label to the nested panel, positioned at the SOUTH
        backgroundPanel.add(backgroundLabel, BorderLayout.SOUTH);

        // Add the nested panel to the main content panel
        contentPane.add(backgroundPanel);

        // Set the main content panel as the content pane of the frame
        setContentPane(contentPane);

        //TODO: ini Map dan Character masih temporary

        selectCharacterPlayers(player1Character, player2Character);

        /**
         * Dilarang keras untuk merubah sourcode dibawah ini tanpa izin/diskusi
         *
         * DAERAH SENSITIF
         */

        //WARNING: No Edit Zone -- Start

        GameInfo.core = new Engine();
        GameInfo.core.setMap(map);


        // Add Event Listener
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (!GameInfo.isGameEnd && GameInfo.core.getNowPlaying() == 1) {

                    switch (keyCode){
                        case KeyEvent.VK_UP -> {
                            GameInfo.core.getPlayer1().goUp();
                            GameInfo.core.getPlayer1().decreaseTurns(1);
                            GameInfo.core.getPlayer1().updatePlayerTurnLabel();
                        }
                        case KeyEvent.VK_DOWN -> {
                            GameInfo.core.getPlayer1().goDown();
                            GameInfo.core.getPlayer1().decreaseTurns(1);
                            GameInfo.core.getPlayer1().updatePlayerTurnLabel();
                        }
                        case KeyEvent.VK_LEFT -> {
                            GameInfo.core.getPlayer1().goLeft();
                            GameInfo.core.getPlayer1().decreaseTurns(1);
                            GameInfo.core.getPlayer1().updatePlayerTurnLabel();
                        }
                        case KeyEvent.VK_RIGHT -> {
                            GameInfo.core.getPlayer1().goRight();
                            GameInfo.core.getPlayer1().decreaseTurns(1);
                            GameInfo.core.getPlayer1().updatePlayerTurnLabel();
                        }
                        default -> {}
                    }


                    GameInfo.core.map.checkStepForSoup(GameInfo.core.getPlayer1());
                    GameInfo.core.getPlayer1().updateLocation();



                } else if (!GameInfo.isGameEnd && GameInfo.core.getNowPlaying() == 2) {

                    switch (keyCode){
                        case KeyEvent.VK_W -> {
                            GameInfo.core.getPlayer2().goUp();
                            GameInfo.core.getPlayer2().decreaseTurns(1);
                            GameInfo.core.getPlayer2().updatePlayerTurnLabel();
                        }
                        case KeyEvent.VK_S -> {
                            GameInfo.core.getPlayer2().goDown();
                            GameInfo.core.getPlayer2().decreaseTurns(1);
                            GameInfo.core.getPlayer2().updatePlayerTurnLabel();
                        }
                        case KeyEvent.VK_A -> {
                            GameInfo.core.getPlayer2().goLeft();
                            GameInfo.core.getPlayer2().decreaseTurns(1);
                            GameInfo.core.getPlayer2().updatePlayerTurnLabel();
                        }
                        case KeyEvent.VK_D -> {
                            GameInfo.core.getPlayer2().goRight();
                            GameInfo.core.getPlayer2().decreaseTurns(1);
                            GameInfo.core.getPlayer2().updatePlayerTurnLabel();
                        }
                        default -> {}
                    }


                    GameInfo.core.map.checkStepForSoup(GameInfo.core.getPlayer2());
                    GameInfo.core.getPlayer2().updateLocation();

                } else {

                }


                GameInfo.core.checkIsThereAWinner();
                GameInfo.core.nextNowPlaying();


                // Developer logic


                if (degbugMode){
                    LOGGER.info("Sekarang giliran : " + GameInfo.core.getNowPlaying() + ", Turns [ " + GameInfo.core.getPlayer1().getTurns() + " , " + GameInfo.core.getPlayer2().getTurns() + " ]");
                    LOGGER.info("Player 1 : " + GameInfo.core.getPlayer1().getCoordinateX() + ", " + GameInfo.core.getPlayer1().getCoordinateY() + "\n" +
                                     "Player 2 : " + GameInfo.core.getPlayer2().getCoordinateX() + ", " + GameInfo.core.getPlayer2().getCoordinateY());
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {}

        });


        //WARNING: No Edit Zone -- End

        setVisible(true);
    }

    private Player getCharacterFromPreset(int preset, String name){
        Player character;
        switch (preset){
            case 0 -> character = new Creeper(name);
            case 1 -> character = new Pig(name);
            case 2 -> character = new Sheep(name);
            case 3 -> character = new Spider(name);
            default -> character = new Spider(name);
        }
        return character;
    }

    void selectCharacterPlayers(int presetP1, int presetP2){
        // Character
        Player player1 = getCharacterFromPreset(presetP1, "Player 1");
        Player player2 = getCharacterFromPreset(presetP2, "Player 2");

        player1.setInitialPosition(FrameInfo.arenaXstart,FrameInfo.arenaYstart);
        player2.setInitialPosition(FrameInfo.arenaXend - FrameInfo.tileSize ,FrameInfo.arenaYend - FrameInfo.tileSize);

        backgroundLabel.add(player1.character);
        backgroundLabel.add(player2.character);

        // Create Map
        map = new Map1("Demo Map");
        map.addPlayers(player1, player2);

        map.generateRandomSoups();
    }
}
