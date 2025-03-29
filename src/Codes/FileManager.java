package Codes;
import java.io.*;
import java.time.LocalDate;
import java.util.List;

import Utils.*;

public class FileManager {

    public void addUserStats(String waterStatsFilepath, User user) {
        String data = String.join("|", user.getName(),user.getEmail(),MyGeneralUtils.formatDateToString(LocalDate.now()),
                    MyGeneralUtils.formatTimeToString(user.getWakeTime()),MyGeneralUtils.formatTimeToString(user.getSleepTime()),
                    String.format("%.2f",user.getWaterGoal()),String.format("%.2f",user.getCurrentIntake()),
                    MyGeneralUtils.formatTimeToString(user.getLastWaterTaken()));
        MyFileUtils.saveInFile(waterStatsFilepath, data);
    }

    public void updateStats(String waterStatsFilepath, User user){
        String userline = MyFileUtils.searchFromFile(waterStatsFilepath, user.getEmail());
        MyFileUtils.deleteLineFromFile(waterStatsFilepath, userline);
        addUserStats(waterStatsFilepath, user);
    }
    public void readUserStats(String waterStatsFilepath, User user) {
        // System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Name", "Date", "Water Goal (ml)", "Water Intake (ml)", "Status");

        List<String> lines = MyFileUtils.readFromFile(waterStatsFilepath);

    }

    public void addUserFeedback(User user, String feedback){
        String data = String.join("|", user.getEmail(),feedback);
    }
}
