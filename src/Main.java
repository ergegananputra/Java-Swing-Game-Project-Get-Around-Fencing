import GUI.GamePlayGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GamePlayGUI gamePlayGUI = new GamePlayGUI(0, true);
        });
    }
}