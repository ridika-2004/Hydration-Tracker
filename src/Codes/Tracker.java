package Codes;
import java.time.*;

import Interfaces.ITracker;
import Utils.*;

public class Tracker implements ITracker{
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

    @Override
    public void trackWater(){
        System.out.println(
                "                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
                "                                                            █             WATER DRINK              █\n" +
                "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n");        
        double watertakenamount = MyGeneralUtils.takeValidDoubleInput(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Enter the amount you drank : "+Color.RESET.getCode());
        user.addWater(watertakenamount, LocalTime.now());
        System.out.println("Added " + watertakenamount + "ml. Total intake: " + user.getCurrentIntake() + "ml.");
        if(user.getCurrentIntake()>=user.getWaterGoal()) {
            System.out.println(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"CONGRATULATIONS!!YOU FULLFILLED YOUR GOAL!!!"+Color.RESET.getCode());
        }
        fileManager.updateStats(waterstatsfile, user);
    }

    @Override
    public boolean needsReminder() {
        LocalTime lastWatertakenTime = user.getLastWaterTaken();
        Duration hasntTakenWaterSince = Duration.between(lastWatertakenTime, LocalTime.now());
        return hasntTakenWaterSince.toMinutes() > reminder_threshold_minute;
    }
}
