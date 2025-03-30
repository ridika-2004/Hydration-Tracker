package Codes;
import java.time.LocalDate;
import java.util.List;

import Utils.*;

public class FileManager {

    private PrintManager printManager;

    public FileManager(PrintManager printManager){
        this.printManager = printManager;
    }

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
        List<String> lines = MyFileUtils.readFromFile(waterStatsFilepath);
        if (lines.isEmpty()) return;

        printManager.printUserStats(lines, user);
    }

    public void addUserFeedback(User user, String feedback, String feedbackfile){
        String data = String.join("|", user.getName(),feedback);
        MyFileUtils.saveInFile(feedbackfile, data);
    }

    public void viewUserFeedback(String feedbackFile, User user) {
        List<String> lines = MyFileUtils.readFromFile(feedbackFile);
        if (lines.isEmpty()) return;
    
        printManager.printFeedbackTable(lines, user.getName());
    }
    
    public void viewAllFeedback(String feedbackFile) {
        List<String> lines = MyFileUtils.readFromFile(feedbackFile);
        if (lines.isEmpty()) return;
    
        printManager.printFeedbackTable(lines, null);
    }

    public void viewAllLogin(String waterstatsfile){
        List<String> lines = MyFileUtils.readFromFile(waterstatsfile);
        if(lines.isEmpty()) return;
        System.out.printf("%-20s%-20s\n", "Name", "Date");
        printManager.printLoginDetails(lines);
    }
}
