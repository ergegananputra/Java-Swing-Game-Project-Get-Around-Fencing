package GUI;

import information.FrameInfo;
import models.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEndGUI extends JFrame {
    private JLabel backgroundLabel;

    public GameEndGUI(int preset, boolean debugMode, Player player) {
        setTitle("Lousy Fencing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameInfo.frameWidth, FrameInfo.frameHeight + 40);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel endPane = new JPanel(new BorderLayout(100,100));
        endPane.setBorder(new EmptyBorder(150,20,150,20));
        JPanel restartPane = new JPanel(new FlowLayout());
        JPanel playerPane = new JPanel(new FlowLayout());

        JLabel restart = new JLabel("PRESS ENTER TO RESTART");
        restart.setFont(new Font("Minecraft", Font.BOLD,20));
//        restartBtn.setPreferredSize(new Dimension(180,70));
        JLabel winner = new JLabel("Player " + player.getName() + " Win!");
        winner.setFont(new Font("Minecraft", Font.BOLD,30));

        restartPane.add(restart);
        playerPane.add(winner);

        endPane.add(restartPane, BorderLayout.SOUTH);
        endPane.add(playerPane, BorderLayout.CENTER);

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
                    case KeyEvent.VK_ESCAPE:
                        dispose();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

//        restartBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                new GamePlayGUI(preset, debugMode);
//            }
//        });

        add(endPane);

        setVisible(true);
    }
}
