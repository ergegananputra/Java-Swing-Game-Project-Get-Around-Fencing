package GUI;

import information.FrameInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HomePageMenuGUI extends JFrame {
    private JLabel backgroundLabel;
    private JLabel selectLabel1;
    private JLabel selectLabel2;
    private int select1Pos;
    private int select2Pos;

    public HomePageMenuGUI(int preset, boolean debugMode) {
        // default value
        select1Pos = -370;
        select2Pos = 100;

        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameInfo.frameWidth, FrameInfo.frameHeight + 40);
        setLocationRelativeTo(null);
        setResizable(false);

        // add background
        ImageIcon background = new ImageIcon("src/assets/background/HomePageMenu.png");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, FrameInfo.frameWidth, FrameInfo.frameHeight);
        add(backgroundLabel);

        // add selection 1
        ImageIcon select1 = new ImageIcon("src/assets/background/OutfitSelection.png");
        selectLabel1 = new JLabel(select1);
        selectLabel1.setBounds(select1Pos, 50, FrameInfo.frameWidth, FrameInfo.frameHeight);
        backgroundLabel.add(selectLabel1);

        // add selection 2
        ImageIcon select2 = new ImageIcon("src/assets/background/OutfitSelection.png");
        selectLabel2 = new JLabel(select2);
        selectLabel2.setBounds(select2Pos, 50, FrameInfo.frameWidth, FrameInfo.frameHeight);
        backgroundLabel.add(selectLabel2);
        
        //TODO: set outfit

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_ENTER:
                        dispose();
                        new GamePlayGUI(preset, debugMode);
                        break;

                    case KeyEvent.VK_W:
                        select1Pos = -370;
                        break;
                    case KeyEvent.VK_A:
                        select1Pos = -285;
                        break;
                    case KeyEvent.VK_S:
                        select1Pos = -200;
                        break;
                    case KeyEvent.VK_D:
                        select1Pos = -115;
                        break;

                    case KeyEvent.VK_RIGHT:
                        select2Pos = 355;
                        break;
                    case KeyEvent.VK_DOWN:
                        select2Pos = 270;
                        break;
                    case KeyEvent.VK_LEFT:
                        select2Pos = 185;
                        break;
                    case KeyEvent.VK_UP:
                        select2Pos = 100;
                        break;

                    default:
                        break;
                }
                selectLabel1.setLocation(select1Pos, selectLabel1.getY());
                selectLabel2.setLocation(select2Pos, selectLabel2.getY());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
            
        });

        setVisible(true);
    }
}
