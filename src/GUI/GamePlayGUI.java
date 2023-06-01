package GUI;
import models.Spider;
import javax.swing.*;
import java.awt.*;

public class GamePlayGUI extends JFrame {
    // Attributes
    private JLabel backgroundLabel;

    // Constructor
    public GamePlayGUI(int preset) {
        FrameInfo.setUserScreenSetting(preset);
        FrameInfo.refresh();
        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameInfo.frameWidth, FrameInfo.frameHeight);
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
        backgroundLabel.add(player1.character);

        setVisible(true);
    }
}
