package GUI;

import javax.swing.JFrame;
import javax.swing.JTextField;

import information.FrameInfo;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class NameInputGUI extends JFrame {
    private HomePageMenuGUI.NameInputCallback callback;
    JTextField textField;
    private String playerName;

    NameInputGUI(HomePageMenuGUI.NameInputCallback callback) {

        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 40);
        setUndecorated(true);
        setResizable(false);

        // Set window position
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2 , dim.height/2-this.getSize().height/2);
        
        // Load External Font
        Font minecraftFont = null;
        try {
            minecraftFont = Font.createFont(Font.TRUETYPE_FONT, FrameInfo.fontFile);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        assert minecraftFont != null;
        Font minecraft = minecraftFont.deriveFont(Font.PLAIN, 28);
        
        // Set font
        setLayout(new FlowLayout());
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(400, 40));
        textField.setFont(minecraft);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);

        add(textField);
        pack();

        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_ENTER -> {
                        playerName = textField.getText();
                        callback.onNameInput(playerName);
                        dispose();
                        break;
                    }
                    default -> {}
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
            
        });

        setVisible(true);
    }

    public String getPlayerName() {
        return playerName;
    }
}
