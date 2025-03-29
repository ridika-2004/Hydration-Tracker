package Codes;
import java.io.*;
import java.time.LocalDate;
import java.util.List;

import Utils.*;

public class FileManager {

    private final String waterStatsFilepath;
    private final String feedbackFile;

    public FileManager(String waterStatsFilepath, String feedbackFile){
        this.waterStatsFilepath = waterStatsFilepath;
        this.feedbackFile = feedbackFile;
    }
    public void addUserStats(User user) {
        String data = String.join("|", user.getName(),user.getEmail(),MyGeneralUtils.formatDateToString(LocalDate.now()),
                    MyGeneralUtils.formatTimeToString(user.getWakeTime()),MyGeneralUtils.formatTimeToString(user.getSleepTime()),
                    String.format("%.2f",user.getWaterGoal()),String.format("%.2f",user.getCurrentIntake()),
                    MyGeneralUtils.formatTimeToString(user.getLastWaterTaken()));
        MyFileUtils.saveInFile(waterStatsFilepath, data);
    }

    public void updateStats(User user){
        String userline = MyFileUtils.searchFromFile(waterStatsFilepath, user.getEmail());
        MyFileUtils.deleteLineFromFile(waterStatsFilepath, userline);
        addUserStats(user);
    }
    public void readUserStats(User user) {
        // System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Name", "Date", "Water Goal (ml)", "Water Intake (ml)", "Status");

        List<String> lines = MyFileUtils.readFromFile(waterStatsFilepath);

    }
}
