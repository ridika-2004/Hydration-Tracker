package Codes;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Reminder {
    private Tracker tracker;
    private Timer reminderTimer;

    public Reminder(Tracker tracker) {
        this.tracker = tracker;
        this.reminderTimer = new Timer();
    }

    public void startReminders() {
        reminderTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (tracker.needsReminder()) {
                    System.out.println("Reminder: Drink water!");
                    playBeepSound();
                }
            }
        }, 0, 60 * 60 * 1000);
    }

    public void stopReminders() {
        reminderTimer.cancel();
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
