package Codes;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import Utils.*;

public class FileManager {

    public void addUserStats(String waterStatsFilepath, User user) {
        String data = String.join("|", user.getName(),MyGeneralUtils.formatDateToString(LocalDate.now()),
                    MyGeneralUtils.formatTimeToString(user.getWakeTime()),MyGeneralUtils.formatTimeToString(user.getSleepTime()),
                    String.format("%.2f",user.getWaterGoal()),String.format("%.2f",user.getCurrentIntake()),
                    MyGeneralUtils.formatTimeToString(user.getLastWaterTaken()));
        MyFileUtils.saveInFile(waterStatsFilepath, data);
    }

    public void updateStats(String waterStatsFilepath, User user){
        String userline = MyFileUtils.searchFromFile(waterStatsFilepath, user.getName());
        MyFileUtils.deleteLineFromFile(waterStatsFilepath, userline);
        addUserStats(waterStatsFilepath, user);
    }
    public void readUserStats(String waterStatsFilepath, User user) {
        // System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Name", "Date", "Water Goal (ml)", "Water Intake (ml)", "Status");

        List<String> lines = MyFileUtils.readFromFile(waterStatsFilepath);

    }

    public void addUserFeedback(User user, String feedback, String feedbackfile){
        String data = String.join("|", user.getName(),feedback);
        MyFileUtils.saveInFile(feedbackfile, data);
    }

    public void viewUserFeedback(String feebackfile, User user){
        List<String> lines = MyFileUtils.readFromFile(feebackfile);
        
        if(lines.isEmpty()) return;

        System.out.printf("%-20s%-20s\n", "Name", "Feedback");
        for(String line : lines){
            String[] parts = line.split("\\|");
            if(parts[MyFileUtils.userNameIndex].equalsIgnoreCase(user.getName())){
                System.out.printf("%-20s%-20s\n", parts[MyFileUtils.userNameIndex], parts[MyFileUtils.feedbackIndex]);
            }
        }
    }

    public void viewAllFeedback(String feebackfile){
        List<String> lines = MyFileUtils.readFromFile(feebackfile);
        if(lines.isEmpty()) return;
        System.out.printf("%-20s%-20s\n", "Name", "Feedback");
        for(String line : lines){
            String[] parts = line.split("\\|");
            System.out.printf("%-20s%-20s\n", parts[MyFileUtils.userNameIndex], parts[MyFileUtils.feedbackIndex]);
        }
    }

    public String userExists(String waterstatsfile, String name){
        String userresult = MyFileUtils.searchFromFile(waterstatsfile, name);
        if(userresult==null) return null;

        String[] parts = userresult.split("\\|");
        LocalDate userDate = MyGeneralUtils.formatStringToDate(parts[MyFileUtils.dateIndex]);
        if(!userDate.equals(LocalDate.now())) return null;
        
        LocalTime sleepTime = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.sleepTimeIndex]);
        if(sleepTime.isBefore(LocalTime.now())) return null;

        LocalTime wakeTime = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.wakeTimeIndex]);
        if(wakeTime.isAfter(LocalTime.now())) return null;
        else return userresult;
    }
}
