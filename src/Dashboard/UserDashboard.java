package Dashboard;

import java.time.LocalTime;

import Codes.*;
import Utils.*;

public class UserDashboard {
    private static final String waterStatsFile = "src/Txt_Files/water_stats.txt";
    private static final String feedbackFile = "src/Txt_Files/feedback.txt";
    private FileManager fileManager = new FileManager();
    private User user;

    String username, useremail;
    LocalTime sleeptime,waketime,lastwatertaken;
    double dailygoal, currentintake;

    public void entercredentials() {
        System.out.println("\n                                                            ╔═════════════════════════════════════╗");
        System.out.println("                                                            ║           ENTER YOUR NAME           ║");
        System.out.println("                                                            ╚═════════════════════════════════════╝");

        username = MyGeneralUtils.takeInput("Enter name : ");

        System.out.println("\n                                                            ╔═════════════════════════════════════╗");
        System.out.println("                                                            ║           ENTER YOUR EMAIL          ║");
        System.out.println("                                                            ╚═════════════════════════════════════╝");
        useremail = MyGeneralUtils.takeUniqueInput(waterStatsFile, "Enter email : ");
        MyGeneralUtils.sleep(1000);
        System.out.println("Taking you to the dashbaord........");
        
        MyGeneralUtils.clearTerminal();
        if(fileManager.userExists(waterStatsFile, useremail)==null) enterDetails();
        else extractDetails(fileManager.userExists(waterStatsFile, useremail));
    }

    private void enterDetails(){
        waketime = MyGeneralUtils.formatStringToTime(MyGeneralUtils.takeInput("Enter waking time : "));
        sleeptime = MyGeneralUtils.formatStringToTime(MyGeneralUtils.takeInput("Enter sleeping time : "));
        dailygoal = MyGeneralUtils.takeValidDoubleInput("Enter daily goal : ");
        user = new User(username, useremail, waketime, sleeptime, dailygoal, 0.0, waketime);

        showOptions();
    }

    private void extractDetails(String details){
        String parts[] = details.split("\\|");
        waketime = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.wakeTimeIndex]);
        sleeptime = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.sleepTimeIndex]);
        dailygoal = Double.parseDouble(parts[MyFileUtils.waterGoalIndex]);
        currentintake = Double.parseDouble(parts[MyFileUtils.currentTakeIndex]);
        lastwatertaken = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.lastWaterTakenIndex]);

        user = new User(details, details, waketime, sleeptime, dailygoal, currentintake, lastwatertaken);

        showOptions();
    }

    private void showOptions(){
        
    }
}
