package information;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class SoundInfo {
    public static final Clip[] footSteps = new Clip[2];
    private static final Random random = new Random();

    public static void setFootSteps() {
        // Load audio files and create Clip objects
        for (int i = 0; i < footSteps.length; i++) {
            try {
                int id = i + 1;
                String filePath = "/assets/sounds/footstep_" + id + ".wav";
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(SoundInfo.class.getResource(filePath)));
                footSteps[i] = AudioSystem.getClip();
                footSteps[i].open(audioInputStream);
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
        }
    }

    public static void playRandomFootstep() {
        int randomIndex = random.nextInt(footSteps.length);
        footSteps[randomIndex].setFramePosition(0);
        footSteps[randomIndex].start();
    }
}
