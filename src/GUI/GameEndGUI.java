package GUI;

import information.FrameInfo;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class GameEndGUI extends JFrame {
    // Attributes
    private final JLabel backgroundLabel;
    private final JLabel playerIcon;

    // Constructor
    public GameEndGUI(int preset, boolean debugMode, Player player) {
        this.playerIcon = player.character;
        FrameInfo.setUserScreenSetting(preset);
        FrameInfo.refresh();

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
        Font minecraft = minecraftFont.deriveFont(Font.PLAIN, 60);

        // Add background
        ImageIcon background = new ImageIcon(FrameInfo.gameEnd);
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0,0, FrameInfo.frameWidth, FrameInfo.frameHeight);
        add(backgroundLabel);

        // Displaying the name of the winner
        JLabel winner = new JLabel(player.getName() + " win!");
        winner.setFont(minecraft);
        winner.setForeground(Color.WHITE);
        winner.setBounds(0,-245, FrameInfo.frameWidth, FrameInfo.frameHeight);
        winner.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundLabel.add(winner);

        // Displaying the icon of the winner
        playerIcon.setBounds(-6,25, FrameInfo.frameWidth, FrameInfo.frameHeight);
        backgroundLabel.add(playerIcon);

        // Add Key Listener
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_ENTER) {
                    dispose();
                    new HomePageMenuGUI(FrameInfo.getUserScreenSetting(), debugMode);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setVisible(true);
    }
}
