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


    // Attributes
    public static JLabel backgroundLabel;

    // Constructor
    public GamePlayGUI(int preset, boolean degbugMode) {
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

        // Panel Info Player 1
        JPanel player1Panel = new JPanel(new FlowLayout());
        player1Panel.setBounds(0, 75, 150, 200);
        player1Panel.setOpaque(false);
        backgroundLabel.add(player1Panel);

        // Content of Panel Info Player 1
        JLabel player1Header = new JLabel("Player 1");
        player1Header.setFont(new Font("Minecraft", Font.BOLD, 30));
        player1Header.setForeground(Color.BLACK);
        player1Panel.add(player1Header);

        JLabel player1InfoTitleText = new JLabel("Available Turns");
        player1InfoTitleText.setFont(new Font("Minecraft", Font.TRUETYPE_FONT, 18));
        player1InfoTitleText.setForeground(Color.BLACK);
        player1Panel.add(player1InfoTitleText);

        int turnsP1 = 0; // Gataw lagi gimana caranya buat nampiin nila dinamisnya
        JLabel player1InfoMovesText = new JLabel(String.valueOf(turnsP1));
        player1InfoMovesText.setFont(new Font("Minecraft", Font.TRUETYPE_FONT, 110));
        player1InfoMovesText.setForeground(Color.BLACK);
        player1Panel.add(player1InfoMovesText);


        // Panel Info Player 2
        JPanel player2Panel = new JPanel(new FlowLayout());
        player2Panel.setBounds(850, 75, 150, 200);
        player2Panel.setOpaque(false);
        backgroundLabel.add(player2Panel);

        // Content of Panel Info Player 2
        JLabel player2Header = new JLabel("Player 2");
        player2Header.setFont(new Font("Minecraft", Font.BOLD, 30));
        player2Header.setForeground(Color.BLACK);
        player2Panel.add(player2Header);

        JLabel player2InfoTitleText = new JLabel("Available Turns");
        player2InfoTitleText.setFont(new Font("Minecraft", Font.TRUETYPE_FONT, 18));
        player2InfoTitleText.setForeground(Color.BLACK);
        player2Panel.add(player2InfoTitleText);

        int turnsP2 = 0; // Gataw lagi gimana caranya buat nampiin nila dinamisnya
        JLabel player2InfoMovesText = new JLabel(String.valueOf(turnsP2));
        player2InfoMovesText.setFont(new Font("Minecraft", Font.TRUETYPE_FONT, 110));
        player2InfoMovesText.setForeground(Color.BLACK);
        player2Panel.add(player2InfoMovesText);


        // Character
        Spider player1 = new Spider("Player 1");
        player1.setInitialPosition(FrameInfo.arenaXstart,FrameInfo.arenaYstart);
        backgroundLabel.add(player1.character);

        Creeper player2 = new Creeper("Player 2");
        player2.setInitialPosition(FrameInfo.arenaXend - FrameInfo.tileSize ,FrameInfo.arenaYend - FrameInfo.tileSize);
        backgroundLabel.add(player2.character);

        // Create Map
        Map1 demoMap = new Map1("Demo Map");
        demoMap.addPlayers(player1, player2);

        // Generate Initial random Soups
//        Soup tes = new Soup("tes", 2, GameInfo.core.map.getTilesRelativeCoorX(2), GameInfo.core.map.getTilesRelativeCoorY(2));
//        JLabel tes.setBounds(50, 50, FrameInfo.tileSize, FrameInfo.tileSize);
        demoMap.generateRandomSoups();

        /**
         * Dilarang keras untuk merubah sourcode dibawah ini tanpa izin/diskusi
         *
         * DAERAH SENSITIF
         */

        //WARNING: No Edit Zone -- Start

        GameInfo.core = new Engine();
        GameInfo.core.setMap(demoMap);


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
                        }
                        case KeyEvent.VK_DOWN -> {
                            GameInfo.core.getPlayer1().goDown();
                            GameInfo.core.getPlayer1().decreaseTurns(1);
                        }
                        case KeyEvent.VK_LEFT -> {
                            GameInfo.core.getPlayer1().goLeft();
                            GameInfo.core.getPlayer1().decreaseTurns(1);
                        }
                        case KeyEvent.VK_RIGHT -> {
                            GameInfo.core.getPlayer1().goRight();
                            GameInfo.core.getPlayer1().decreaseTurns(1);
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
                        }
                        case KeyEvent.VK_S -> {
                            GameInfo.core.getPlayer2().goDown();
                            GameInfo.core.getPlayer2().decreaseTurns(1);
                        }
                        case KeyEvent.VK_A -> {
                            GameInfo.core.getPlayer2().goLeft();
                            GameInfo.core.getPlayer2().decreaseTurns(1);
                        }
                        case KeyEvent.VK_D -> {
                            GameInfo.core.getPlayer2().goRight();
                            GameInfo.core.getPlayer2().decreaseTurns(1);
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
}
