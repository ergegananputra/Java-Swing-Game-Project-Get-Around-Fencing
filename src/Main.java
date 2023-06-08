import GUI.HomePageMenuGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomePageMenuGUI gamePlayGUI = new HomePageMenuGUI(1, true);
        });
    }
}