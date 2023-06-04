package GUI;
import core.Engine;
import information.FrameInfo;
import information.GameInfo;
import models.Map1;
import models.Spider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;

public class GamePlayGUI extends JFrame {
    // Developer Atributes
    private static final Logger LOGGER = Logger.getLogger(GamePlayGUI.class.getName());


    // Attributes
    private JLabel backgroundLabel;

    // Constructor
    public GamePlayGUI(int preset, boolean degbugMode) {
        // Set User Screen Setting Preference
        FrameInfo.setUserScreenSetting(preset);
        FrameInfo.refresh();

        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameInfo.frameWidth, FrameInfo.frameHeight + 40);
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

        // Character
        Spider player1 = new Spider("Player 1");
        player1.setInitialPosition(FrameInfo.arenaXstart,FrameInfo.arenaYstart);
        backgroundLabel.add(player1.character);

        Spider player2 = new Spider("Player 2");
        player2.setInitialPosition(FrameInfo.arenaXend - FrameInfo.tileSize ,FrameInfo.arenaYend - FrameInfo.tileSize);
        backgroundLabel.add(player2.character);

        // Create Map
        Map1 demoMap = new Map1("Demo Map");
        demoMap.addPlayers(player1, player2);


        /**
         * Dilarang keras untuk merubah sourcode dibawah ini tanpa izin/diskusi
         *
         * DAERAH SENSITIF
         */

        //WARNING: No Edit Zone -- Start

        Engine core = new Engine();
        core.setMap(demoMap);

        // Add Event Listener
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (core.getNowPlaying() == 1 && !GameInfo.isGameEnd) {

                    switch (keyCode){
                        case KeyEvent.VK_UP -> {
                            core.getPlayer1().goUp();
                            core.getPlayer1().decreaseTurns(1);
                        }
                        case KeyEvent.VK_DOWN -> {
                            core.getPlayer1().goDown();
                            core.getPlayer1().decreaseTurns(1);
                        }
                        case KeyEvent.VK_LEFT -> {
                            core.getPlayer1().goLeft();
                            core.getPlayer1().decreaseTurns(1);
                        }
                        case KeyEvent.VK_RIGHT -> {
                            core.getPlayer1().goRight();
                            core.getPlayer1().decreaseTurns(1);
                        }
                        default -> {}
                    }

                    core.getPlayer1().updateLocation();
                    core.nextNowPlaying();


                } else if (core.getNowPlaying() == 2 && !GameInfo.isGameEnd) {

                    switch (keyCode){
                        case KeyEvent.VK_W -> {
                            core.getPlayer2().goUp();
                            core.getPlayer2().decreaseTurns(1);
                        }
                        case KeyEvent.VK_S -> {
                            core.getPlayer2().goDown();
                            core.getPlayer2().decreaseTurns(1);
                        }
                        case KeyEvent.VK_A -> {
                            core.getPlayer2().goLeft();
                            core.getPlayer2().decreaseTurns(1);
                        }
                        case KeyEvent.VK_D -> {
                            core.getPlayer2().goRight();
                            core.getPlayer2().decreaseTurns(1);
                        }
                        default -> {}
                    }
                    core.getPlayer2().updateLocation();
                    core.nextNowPlaying();

                } else {

                }


                // Developer logic


                if (degbugMode){
                    LOGGER.info("Sekarang giliran : " + core.getNowPlaying() + ", Turns [ " + core.getPlayer1().getTurns() + " , " + core.getPlayer2().getTurns() + " ]");
                    if (core.getNowPlaying()== 1){
                        LOGGER.info(core.getPlayer1().character.getLocation().toString());
                    } else if (core.getNowPlaying() == 2){
                        LOGGER.info(core.getPlayer2().character.getLocation().toString());
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {}

        });


        //WARNING: No Edit Zone -- End

        setVisible(true);
    }
}
