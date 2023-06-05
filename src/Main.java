import GUI.GameEndGUI;
import GUI.GamePlayGUI;
import models.Player;
import models.Spider;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GamePlayGUI(1,true);
        });
    }
}