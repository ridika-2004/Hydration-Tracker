package Codes;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Utils.MyGeneralUtils;

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
                    System.out.println("\nReminder : Drink water!");
                    playBeepSound();
                    MyGeneralUtils.sleep(3000);
                    // MyGeneralUtils.clearTerminal();
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