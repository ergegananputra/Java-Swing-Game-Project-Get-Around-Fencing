package models;

import information.SoundInfo;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.Objects;

public class GameSound {
    private Clip[] footSteps;
    private Clip eatSfx;

    void setFootSteps() {
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

    void playRandomFootstep() {
        int randomIndex = (int) (Math.random() * footSteps.length);
        Clip newClip = footSteps[randomIndex];

        if (newClip.isRunning()) {
            newClip.stop();
        }

        newClip.setFramePosition(0);
        newClip.start();
    }

    void setEatSfx(){
        try {
            String filePath = "/assets/sounds/MinecraftEating_1.wav";
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(SoundInfo.class.getResource(filePath)));
            eatSfx = AudioSystem.getClip();
            eatSfx.open(audioInputStream);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    void playEatSfx(){
        eatSfx.setFramePosition(0);
        eatSfx.start();
    }
}
