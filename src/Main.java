import GUI.HomePageMenuGUI;
import information.FrameInfo;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomePageMenuGUI gamePlayGUI = new HomePageMenuGUI(0, true);
        });
    }
}