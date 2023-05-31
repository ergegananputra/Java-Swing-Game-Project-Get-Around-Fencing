package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GamePlayGUI extends JFrame {
    // Attributes
    private JLabel backgroundLabel;
    int minWidth = 800;
    int minHeight = 800;

    private JLabel characterLabel;

    // Constructor
    public GamePlayGUI() {
        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameInfo.frameWidth, FrameInfo.frameHeight);
        setLocationRelativeTo(null);
        setResizable(false);

        // Set Minimum Size
        setMinimumSize(new Dimension(minWidth, minHeight));

        // Initialize Background Label
        ImageIcon backgroundImage = new ImageIcon("src/assets/placeholder.png");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, minWidth, minHeight);
        add(backgroundLabel); // Attach background

        // Character
        ImageIcon characterImage = new ImageIcon("src/assets/characters/Creeper.png");
        characterLabel = new JLabel(characterImage);
        characterLabel.setBounds(400, 400, FrameInfo.tileSize, FrameInfo.tileSize);
        backgroundLabel.add(characterLabel);

        setVisible(true);
    }
}
