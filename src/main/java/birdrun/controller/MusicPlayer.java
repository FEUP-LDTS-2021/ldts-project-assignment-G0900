package birdrun.controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.util.Objects;

@SuppressWarnings("CatchAndPrintStackTrace")

public class MusicPlayer {
    private Clip backgroundMusic;
    private Clip coinSound;
    private Clip deadSound;
    private Clip damageSound;

    public MusicPlayer() {
        loadMusicFiles();
    }

    private void loadMusicFiles() {
        try {
            this.backgroundMusic = loadBackgroundMusic();
            this.coinSound = loadCoinSound();
            this.deadSound = loadDeadSound();
            this.damageSound = loadDamageSound();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Clip loadDamageSound() {
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/sounds/damage_sound.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Clip loadDeadSound() {
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/sounds/dead_sound.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Clip loadBackgroundMusic() {
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/sounds/bg_music.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Clip loadCoinSound() {
        try {
            File musicFile = new File(Objects.requireNonNull(MusicPlayer.class.getResource("/sounds/coin_sound.wav")).getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void starBackGroundMusic() {
        if (backgroundMusic == null) return;
        backgroundMusic.setMicrosecondPosition(0);
        backgroundMusic.start();
        backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopBackGroundMusic() {

        if (backgroundMusic == null) return;
        backgroundMusic.stop();
    }

    public void playCoinSound() {
        if (coinSound == null) return;
        coinSound.setMicrosecondPosition(0);
        coinSound.start();
    }

    public void playDeadSound() {
        if (deadSound == null) return;
        deadSound.setMicrosecondPosition(0);
        deadSound.start();
    }

    public void playDamageSound() {
        if (damageSound == null) return;
        damageSound.setMicrosecondPosition(0);
        damageSound.start();
    }

    public void resumeBackGroundMusic() {
        backgroundMusic.start();

    }
}