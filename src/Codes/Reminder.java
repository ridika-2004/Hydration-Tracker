package Codes;
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;
import Interfaces.ITracker;
import Utils.*;

public class Reminder {
    private ITracker tracker;
    private Timer reminderTimer;

    public Reminder(ITracker tracker) {
        this.tracker = tracker;
        this.reminderTimer = new Timer();
    }
    public void startReminders() {
        reminderTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (tracker.needsReminder()) {
                    System.out.println(Color.RED.getCode()+Color.BOLD.getCode()+"\nReminder : Drink water!"+Color.RESET.getCode());
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