package GUI;

import information.FrameInfo;
import models.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEndGUI extends JFrame {

    // Constructor
    public GameEndGUI(int preset, boolean debugMode, Player player) {
        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameInfo.frameWidth, FrameInfo.frameHeight + 40);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create an outer panel with a BorderLayout
        JPanel endPane = new JPanel(new BorderLayout(100,100));
        endPane.setBorder(new EmptyBorder(100,0,150,0)); // Set the padding
        endPane.setBackground(Color.BLACK);

        // Create an inner panel to display the image of the winner with a FlowLayout
        JPanel icon = new JPanel(new FlowLayout());
        icon.setBackground(Color.BLACK);
        // Adding the player image to the panel
        icon.add(player.character);
        endPane.add(icon, BorderLayout.NORTH);

        // Create an inner panel to display the name of the winner with a FlowLayout
        JPanel playerPane = new JPanel(new FlowLayout());
        playerPane.setBackground(Color.BLACK);

        // Create an inner panel to display restart instruction with a FlowLayout
        JPanel restartPane = new JPanel(new FlowLayout());
        restartPane.setBackground(Color.BLACK);

        // Create a label to display the name of the winner
        JLabel winner = new JLabel(player.getName() + " Win!");
        winner.setFont(new Font("Arial", Font.BOLD,60));
        winner.setForeground(Color.WHITE);
        // Adding it to the panel
        playerPane.add(winner);
        endPane.add(playerPane, BorderLayout.CENTER);

        // Create a label for the restart instruction
        JLabel restart = new JLabel("PRESS ENTER TO RESTART");
        restart.setFont(new Font("Arial", Font.BOLD,20));
        restart.setForeground(Color.WHITE);
        // Adding it to the panel
        restartPane.add(restart);
        endPane.add(restartPane, BorderLayout.SOUTH);

        // Add Key Listener
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
//                    case KeyEvent.VK_ESCAPE:
//                        dispose();
//                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        add(endPane);

        setVisible(true);
    }
}
