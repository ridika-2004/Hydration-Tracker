package Codes;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Reminder {
    private Timer reminderTimer;

    public Reminder() {
        this.reminderTimer = new Timer();
    }

    public void startReminders(boolean needsReminder) {
        reminderTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (needsReminder) {
                    System.out.println("Reminder: Drink water!");
                    playBeepSound();
                }
            }
        }, 0, 1 * 60 * 1000);
    }

    private void playBeepSound() {
        try {
            File soundFile = new File("src\\sound\\reminder.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {}
    }
}