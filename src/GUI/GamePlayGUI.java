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
        setSize(1440, 1080);
        setLocationRelativeTo(null);
        setResizable(true);

        // Set Minimum Size
        setMinimumSize(new Dimension(minWidth, minHeight));

        // Initialize Background Label
        ImageIcon backgroundImage = new ImageIcon("src/assets/placeholder.png");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, minWidth, minHeight);
        add(backgroundLabel); // Attach background

        // Character
        ImageIcon characterImage = new ImageIcon("src/assets/characters/heho1.png");
        characterLabel = new JLabel(characterImage);
        characterLabel.setBounds(0, 0, minWidth, minHeight);
        backgroundLabel.add(characterLabel);

        // Add component listener for resize events
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateCharacterPosition();
            }
        });

        setVisible(true);
    }

    // Update character position based on window size
    private void updateCharacterPosition() {
        Dimension screenSize = backgroundLabel.getSize();
        int centerX = screenSize.width / 2 - characterLabel.getWidth() / 2;
        int centerY = screenSize.height / 2 - characterLabel.getHeight() / 2;
        characterLabel.setLocation(centerX, centerY);
    }
}
