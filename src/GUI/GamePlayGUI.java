package GUI;
import models.Player;
import models.Spider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.*;

public class GamePlayGUI extends JFrame {
    private static final Logger LOGGER = Logger.getLogger(GamePlayGUI.class.getName());
    // Attributes
    private JLabel backgroundLabel;

    // Constructor
    public GamePlayGUI(int preset, boolean degbugMode) {
        FrameInfo.setUserScreenSetting(preset);
        FrameInfo.refresh();

        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameInfo.frameWidth, FrameInfo.frameHeight + 40);
        setLocationRelativeTo(null);
        setResizable(false);

//        // Initialize Background Label
//        ImageIcon backgroundImageOriginal = new ImageIcon(FrameInfo.background);
//        Image backgroundImage = backgroundImageOriginal.getImage();
//        Image scaledImage = backgroundImage.getScaledInstance(FrameInfo.frameWidth, FrameInfo.frameHeight, Image.SCALE_SMOOTH);
//        backgroundLabel = new JLabel(new ImageIcon(scaledImage));
//        backgroundLabel.setBounds(0, 0, FrameInfo.frameWidth, FrameInfo.frameHeight);
//        add(backgroundLabel); // Attach background

        // Create the main content panel with a BorderLayout
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.BLACK); // Set the background color of the content pane

        // Create a nested panel for background image with a BorderLayout
        JPanel backgroundPanel = new JPanel(new BorderLayout());
        backgroundPanel.setBackground(Color.BLACK); // Set the background color of the background panel

        // Initialize Background Label
        ImageIcon backgroundImage = new ImageIcon(FrameInfo.background);
        backgroundLabel = new JLabel(backgroundImage);

        // Add the background label to the nested panel, positioned at the SOUTH
        backgroundPanel.add(backgroundLabel, BorderLayout.SOUTH);

        // Add the nested panel to the main content panel
        contentPane.add(backgroundPanel);

        // Set the main content panel as the content pane of the frame
        setContentPane(contentPane);

        // Character
        Spider player1 = new Spider();
        player1.setInitialPosition(FrameInfo.arenaXstart,FrameInfo.arenaYstart);
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
                if (degbugMode){
                    LOGGER.info(player1.character.getLocation().toString());
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setVisible(true);
    }
}
