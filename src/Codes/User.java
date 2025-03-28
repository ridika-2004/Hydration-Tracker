package Codes;
import java.time.*;

public class User {
    private String name, email;
    private LocalTime wakeTime, sleepTime, lastWaterTaken;
    private double waterGoal, currentIntake;

    public User(String name, String email, LocalTime wakeTime, LocalTime sleepTime, double waterGoal) {
        this.name = name;
        this.email = email;
        this.wakeTime = wakeTime;
        this.sleepTime = sleepTime;
        this.waterGoal = waterGoal;
        this.currentIntake = 0.0;
        this.lastWaterTaken = wakeTime;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getEmail(){
        return email;
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
