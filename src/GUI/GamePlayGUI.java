package GUI;
import models.Player;
import models.Spider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlayGUI extends JFrame {
    // Attributes
    private JLabel backgroundLabel;

    // Constructor
    public GamePlayGUI(int preset) {
        FrameInfo.setUserScreenSetting(preset);
        FrameInfo.refresh();

        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameInfo.frameWidth, FrameInfo.frameHeight + 80);
        setLocationRelativeTo(null);
        setResizable(false);

        // Initialize Background Label
        ImageIcon backgroundImageOriginal = new ImageIcon(FrameInfo.background);
        Image backgroundImage = backgroundImageOriginal.getImage();
        Image scaledImage = backgroundImage.getScaledInstance(FrameInfo.frameWidth, FrameInfo.frameHeight, Image.SCALE_SMOOTH);
        backgroundLabel = new JLabel(new ImageIcon(scaledImage));
        backgroundLabel.setBounds(0, 0, FrameInfo.frameWidth, FrameInfo.frameHeight);
        add(backgroundLabel); // Attach background

        // Character
        Spider player1 = new Spider();
        player1.setInitialPosition(FrameInfo.arenaXstart,FrameInfo.arenaYstart);
        player1.updateLocation();
        System.out.println(player1.character.getHorizontalTextPosition());
        backgroundLabel.add(player1.character);

        // Add Event Listener
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP -> player1.goUp();
                    case KeyEvent.VK_DOWN -> player1.goDown();
                    case KeyEvent.VK_LEFT -> player1.goLeft();
                    case KeyEvent.VK_RIGHT -> player1.goRight();
                    default -> {}
                }
                player1.updateLocation();
                System.out.println(player1.character.getLocation().toString());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setVisible(true);
    }
}
