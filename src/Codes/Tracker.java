package Codes;
import java.time.Duration;
import java.time.LocalTime;

import Utils.*;

public class Tracker {
    private User user;
    private String waterstatsfile;
    private FileManager fileManager;
    private PrintManager printManager;
    final int reminder_threshold_minute = 120;

    public Tracker(String waterstatsfile, User user) {
        this.waterstatsfile = waterstatsfile;
        this.user = user;
        this.printManager = new PrintManager();
        fileManager = new FileManager(printManager);
    }

    public void trackWater(){
        double watertakenamount = MyGeneralUtils.takeValidDoubleInput("Enter the amount you drank : ");
        user.addWater(watertakenamount, LocalTime.now());
        System.out.println("Added " + watertakenamount + "ml. Total intake: " + user.getCurrentIntake() + "ml.");
        fileManager.updateStats(waterstatsfile, user);
    }

    public boolean hasMetGoal() {
        return user.getCurrentIntake() >= user.getWaterGoal();
    }

    public boolean needsReminder() {
        LocalTime lastWatertakenTime = user.getLastWaterTaken();
        Duration hasntTakenWaterSince = Duration.between(lastWatertakenTime, LocalTime.now());
        return hasntTakenWaterSince.toMinutes() > reminder_threshold_minute;
    }
}
