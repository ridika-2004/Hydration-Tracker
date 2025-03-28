package Codes;
import java.util.Timer;
import java.util.TimerTask;

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
                }
            }
        }, 0, 60 * 60 * 1000);
    }

    public void stopReminders() {
        reminderTimer.cancel();
    }
}
