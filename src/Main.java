import GUI.GamePlayGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GamePlayGUI(2, true);
        });
    }
}