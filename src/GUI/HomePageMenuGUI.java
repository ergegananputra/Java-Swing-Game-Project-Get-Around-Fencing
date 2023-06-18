package GUI;

import core.Engine;
import information.FrameInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Logger;

public class HomePageMenuGUI extends JFrame {
    // ATTRIBUTES
    private final JLabel backgroundLabel;
    private final JLabel selectLabel1;
    private final JLabel selectLabel2;
    private int select1Pos;
    private int select2Pos;
    private String player1Name;
    private String player2Name;



    // CONSTRUCTORS
    public HomePageMenuGUI(int preset, boolean debugMode) {
        FrameInfo.setUserScreenSetting(preset);
        FrameInfo.refresh();


        // default value
        select1Pos = -370;
        select2Pos = 100;

        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameInfo.frameWidth, FrameInfo.frameHeight + 40);
        setLocationRelativeTo(null);
        setResizable(false);

        // Load External Font
        Font minecraftFont = null;
        try {
            minecraftFont = Font.createFont(Font.TRUETYPE_FONT, FrameInfo.fontFile);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        assert minecraftFont != null;
        Font minecraft = minecraftFont.deriveFont(Font.PLAIN, 28);

        // add background
        ImageIcon background = new ImageIcon(FrameInfo.homePageMenu);
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 100, FrameInfo.frameWidth, FrameInfo.frameHeight);
        add(backgroundLabel);

        // add cover pane
        ImageIcon cover = new ImageIcon(FrameInfo.coverPane);
        JLabel coverLabel = new JLabel(cover);
        coverLabel.setBounds(0, 20, FrameInfo.frameWidth, FrameInfo.frameHeight);
        backgroundLabel.add(coverLabel);

        // add selection 1
        ImageIcon select1 = new ImageIcon(FrameInfo.outfitSelection);
        selectLabel1 = new JLabel(select1);
        selectLabel1.setBounds(select1Pos, 50, FrameInfo.frameWidth, FrameInfo.frameHeight);
        backgroundLabel.add(selectLabel1);

        // add selection 2
        ImageIcon select2 = new ImageIcon(FrameInfo.outfitSelection);
        selectLabel2 = new JLabel(select2);
        selectLabel2.setBounds(select2Pos, 50, FrameInfo.frameWidth, FrameInfo.frameHeight);
        backgroundLabel.add(selectLabel2);

        // add action label
        JLabel actionLabel = new JLabel("Enter player 1 name");
        actionLabel.setFont(minecraft);
        actionLabel.setForeground(Color.decode("#C6C6C6"));
        actionLabel.setBounds(-10, -230, FrameInfo.frameWidth, FrameInfo.frameHeight);
        actionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundLabel.add(actionLabel);
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_ENTER -> {
                        dispose();
                        int player1Character;
                        switch (select2Pos) {
                            case 100 -> player1Character = 0;
                            case 185 -> player1Character = 1;
                            case 270 -> player1Character = 2;
                            case 355 -> player1Character = 3;
                            default -> {
                                player1Character = 0;
                                if(debugMode){
                                    Logger.getLogger("Home Page Menu, Character Selection").info("Anomaly in Character Selection. Pos Selection default to 0");
                                }
                            }
                        }
                        int player2Character;
                        switch (select1Pos) {
                            case -370 -> player2Character = 0;
                            case -285 -> player2Character = 1;
                            case -200 -> player2Character = 2;
                            case -115 -> player2Character = 3;
                            default -> {
                                player2Character = 0;
                                if(debugMode){
                                    Logger.getLogger("Home Page Menu, Character Selection").info("Anomaly in Character Selection. Pos Selection default to 0");
                                }
                            }
                        }
                        Engine.gamePlayGUI = new GamePlayGUI(preset, debugMode, player1Character, player2Character, player1Name, player2Name);
                    }
                    case KeyEvent.VK_W -> select1Pos = -370;
                    case KeyEvent.VK_A -> select1Pos = -285;
                    case KeyEvent.VK_S -> select1Pos = -200;
                    case KeyEvent.VK_D -> select1Pos = -115;
                    case KeyEvent.VK_RIGHT -> select2Pos = 355;
                    case KeyEvent.VK_DOWN -> select2Pos = 270;
                    case KeyEvent.VK_LEFT -> select2Pos = 185;
                    case KeyEvent.VK_UP -> select2Pos = 100;
                    default -> System.out.println(player1Name);
                }
                selectLabel1.setLocation(select1Pos, selectLabel1.getY());
                selectLabel2.setLocation(select2Pos, selectLabel2.getY());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
            
        });

        setVisible(true);

        // name input
        // player 1 name
        new NameInputGUI(name -> {
            player1Name = name;

            // set text action label
            actionLabel.setText("Enter player 2 name");
            backgroundLabel.add(actionLabel);
            setVisible(true);

            // player 2 name
            new NameInputGUI(new NameInputCallback() {
                @Override
                public void onNameInput(String name) {
                player2Name = name;

                // remove cover pane
                coverLabel.setIcon(null);

                // set name label for both player
                JLabel player1NameLabel = new JLabel(player1Name);
                player1NameLabel.setFont(minecraft);
                player1NameLabel.setForeground(Color.WHITE);
                player1NameLabel.setBounds(-240, -120, FrameInfo.frameWidth, FrameInfo.frameHeight);
                player1NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
                backgroundLabel.add(player1NameLabel);

                JLabel player2NameLabel = new JLabel(player2Name);
                player2NameLabel.setFont(minecraft);
                player2NameLabel.setForeground(Color.WHITE);
                player2NameLabel.setBounds(220, -120, FrameInfo.frameWidth, FrameInfo.frameHeight);
                player2NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
                backgroundLabel.add(player2NameLabel);

                // set text action label
                actionLabel.setText("Select your outfit");
                backgroundLabel.add(actionLabel);

                setVisible(true);
                }
            });
        });
        
    }


    // INNER CLASS
    interface NameInputCallback {
        void onNameInput(String name);
    }
}
