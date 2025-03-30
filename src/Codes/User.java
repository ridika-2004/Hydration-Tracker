package Codes;
import java.time.*;

public class User {
    private String name;
    private LocalTime wakeTime, sleepTime, lastWaterTaken;
    private double waterGoal, currentIntake;

    public User(String name, LocalTime wakeTime, LocalTime sleepTime, double waterGoal, double currentIntake, LocalTime lastwatertakentime) {
        this.name = name;
        this.wakeTime = wakeTime;
        this.sleepTime = sleepTime;
        this.waterGoal = waterGoal;
        this.currentIntake = currentIntake;
        this.lastWaterTaken = lastwatertakentime;
    }
    public String getName() {
        return name;
    }

    public LocalTime getWakeTime() {
        return wakeTime;
    }

    public LocalTime getSleepTime() {
        return sleepTime;
    }

    public LocalTime getLastWaterTaken() {
        return lastWaterTaken;
    }

    public double getWaterGoal() {
        return waterGoal;
    }

    public double getCurrentIntake(){
        return currentIntake;
    }

    private void setLastWaterTaken(LocalTime lastWaterTaken) {
        this.lastWaterTaken = lastWaterTaken;
    }

    private void setCurrentInTake(double currentIntake) {
        this.currentIntake = currentIntake;
    }

    public void addWater(double amount, LocalTime lastwatertakentime) {
        setCurrentInTake(getCurrentIntake()+amount);
        setLastWaterTaken(lastwatertakentime);
    }

}
