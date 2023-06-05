import GUI.GamePlayGUI;
import GUI.HomePageMenuGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // GamePlayGUI gamePlayGUI = new GamePlayGUI(0, true);
            HomePageMenuGUI home = new HomePageMenuGUI(0, true);
        });
    }
}