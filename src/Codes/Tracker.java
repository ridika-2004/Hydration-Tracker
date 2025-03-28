package Codes;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class Tracker {
    private User user;

    public Tracker(User user) {
        this.user = user;
    }

    public void addWater(double amount, LocalTime time) {
        user.addWater(amount, time);
        System.out.println("Added " + amount + "ml. Total intake: " + user.getCurrentIntake() + "ml.");
    }

    public boolean hasMetGoal() {
        return user.getCurrentIntake() >= user.getWaterGoal();
    }

    public boolean needsReminder() {
        long minutesSinceLastDrink = Duration.between(user.getLastWaterTaken(), Instant.now()).toMinutes();
        return minutesSinceLastDrink >= 180 && !hasMetGoal();
    }
}
