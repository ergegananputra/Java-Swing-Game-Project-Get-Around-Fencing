import GUI.HomePageMenuGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePageMenuGUI(3, false));
    }
}