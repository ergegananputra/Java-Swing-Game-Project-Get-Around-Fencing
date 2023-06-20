package information;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.Objects;

public class SoundInfo {

    private static Clip backgroundMusic;
    private static String[] musicLibrary = {"/assets/sounds/BeneathTheMoonlightSounds.wav", "/assets/sounds/PigStepFromMojang.wav"};



    static void setBackgroundMusic(int select, float volume) {
        try {
            String filePath = musicLibrary[select];
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(SoundInfo.class.getResource(filePath)));
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioInputStream);

            // Adjust the volume if supported
            if (backgroundMusic.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                FloatControl volumeControl = (FloatControl) backgroundMusic.getControl(FloatControl.Type.MASTER_GAIN);

                // Calculate the volume gain in decibels (dB)
                float gain = (float) (Math.log10(volume) * 20);
                volumeControl.setValue(gain);
            }

            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
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
