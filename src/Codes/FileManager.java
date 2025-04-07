package Codes;
import java.time.*;
import java.util.*;

import Interfaces.IFileManager;
import Interfaces.IPrintManager;
import Utils.*;

public class FileManager implements IFileManager {

    private IPrintManager printManager;

    public FileManager(IPrintManager printManager){
        this.printManager = printManager;
    }

    @Override
    public void addUserStats(String waterStatsFilepath, User user) {
        String data = String.join("|", user.getName(),MyGeneralUtils.formatDateToString(LocalDate.now()),
                    MyGeneralUtils.formatTimeToString(user.getWakeTime()),MyGeneralUtils.formatTimeToString(user.getSleepTime()),
                    String.format("%.2f",user.getWaterGoal()),String.format("%.2f",user.getCurrentIntake()),
                    MyGeneralUtils.formatTimeToString(user.getLastWaterTaken()));
        MyFileUtils.saveInFile(waterStatsFilepath, data);
    }

    @Override
    public void updateStats(String waterStatsFilepath, User user){
        String userline = MyFileUtils.searchFromFile(waterStatsFilepath, user.getName());
        MyFileUtils.deleteLineFromFile(waterStatsFilepath, userline);
        addUserStats(waterStatsFilepath, user);
    }
    @Override
    public void readUserStats(String waterStatsFilepath, User user) {
        List<String> lines = MyFileUtils.readFromFile(waterStatsFilepath);
        if (lines.isEmpty()) return;

        printManager.printUserStats(lines, user);
    }

    @Override
    public void addUserFeedback(User user, String feedback, String feedbackfile){
        String data = String.join("|", user.getName(),feedback);
        MyFileUtils.saveInFile(feedbackfile, data);
    }
    
    @Override
    public void viewAllFeedback(String feedbackFile) {
        List<String> lines = MyFileUtils.readFromFile(feedbackFile);
        if (lines.isEmpty()) return;
    
        printManager.printFeedbackTable(lines, null);
    }

    @Override
    public void viewAllLogin(String waterstatsfile){
        List<String> lines = MyFileUtils.readFromFile(waterstatsfile);
        if(lines.isEmpty()) return;
        printManager.printLoginDetails(lines);
    }
}
