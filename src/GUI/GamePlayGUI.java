package GUI;

import javax.swing.*;
import java.awt.*;

public class GamePlayGUI extends JFrame {
    // Atributes
    private JLabel backgroundLabel;
    int minWidth = 800;
    int minHeight = 800;

    private JLabel characterLabel;

    // Constructor
    public GamePlayGUI(){
        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1080);
        setLocationRelativeTo(null);
        setResizable(true);

        // Set Minimum Size
        setMinimumSize(new Dimension(minWidth, minHeight));

        // Inisialize Background Label
        ImageIcon backgroundImage = new ImageIcon("src/assets/placeholder.png");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, minWidth, minHeight);
        add(backgroundLabel); // Menempel background

        // Character
        ImageIcon characterImage = new ImageIcon("src/assets/characters/H2-Heho Letter Logo.png");
        characterLabel = new JLabel();
        characterLabel.setBounds(400, 400, 40, 40);
        backgroundLabel.add(characterLabel);


        setVisible(true);
    }
}
