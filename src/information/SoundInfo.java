package information;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.Objects;

public class SoundInfo {
    private Clip[] footSteps;
    private static Clip backgroundMusic;

    public SoundInfo() {
        setFootSteps();
    }

    private void setFootSteps() {
        footSteps = new Clip[2];
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

    static void setBackgroundMusic() {
        try {
            String filePath = "/assets/sounds/PigStepFromMojang.wav";
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(SoundInfo.class.getResource(filePath)));
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioInputStream);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundMusic.stop();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void playRandomFootstep() {
        int randomIndex = (int) (Math.random() * footSteps.length);
        Clip newClip = footSteps[randomIndex];

        if (newClip.isRunning()) {
            newClip.stop();
        }

        newClip.setFramePosition(0);
        newClip.start();
    }

    void playBackgroundMusic() {
        if (!backgroundMusic.isRunning()) {
            backgroundMusic.setFramePosition(0);
            backgroundMusic.start();
        }
    }

    void stopBackgroundMusic() {
        if (backgroundMusic.isRunning()) {
            backgroundMusic.stop();
        }
    }
}
