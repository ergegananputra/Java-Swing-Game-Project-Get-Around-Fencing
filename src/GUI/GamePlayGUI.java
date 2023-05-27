package GUI;

import javax.swing.*;
import java.awt.*;

public class GamePlayGUI extends JFrame {
    // Atributes
    private JLabel backgroundLabel;
    int minWidth = 800;
    int minHeight = 800;

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




        setVisible(true);
    }
}
