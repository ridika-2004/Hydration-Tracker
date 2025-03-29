package Codes;
import java.time.Duration;
import java.time.LocalTime;

import Utils.*;

public class Tracker {
    private User user;
    private String filepath;
    final int reminder_threshold_minute = 120;

    public Tracker(String filepath, User user) {
        this.filepath = filepath;
        this.user = user;
    }

    public void trackWater(){
        System.out.println("1. add water");
        System.out.println("2. give feedback");
        System.out.println("3. see today's stats");
        System.out.println("4. view all stats");
        System.out.println("5. view water needs for people");
        System.out.println("6. about this app");

        double watertakenamount = MyGeneralUtils.takeValidDoubleInput("Enter the amount you drank : ");

        addWater(watertakenamount, LocalTime.now());
    }

    public void addWater(double amount, LocalTime time) {
        user.addWater(amount, time);
        System.out.println("Added " + amount + "ml. Total intake: " + user.getCurrentIntake() + "ml.");
        FileManager.updateStats(filepath, user);
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
