package GUI;
import models.Spider;
import javax.swing.*;

public class GamePlayGUI extends JFrame {
    // Attributes
    private JLabel backgroundLabel;

    // Constructor
    public GamePlayGUI(int preset) {
        FrameInfo.setUserScreenSetting(preset);
        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameInfo.frameWidth, FrameInfo.frameHeight);
        setLocationRelativeTo(null);
        setResizable(false);

        // Initialize Background Label
        ImageIcon backgroundImage = new ImageIcon(FrameInfo.background);
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, FrameInfo.frameWidth, FrameInfo.frameHeight);
        add(backgroundLabel); // Attach background

        // Character
        Spider player1 = new Spider();
        player1.setInitialPosition(FrameInfo.arenaXstart,FrameInfo.arenaYstart);
        backgroundLabel.add(player1.character);

        setVisible(true);
    }
}
