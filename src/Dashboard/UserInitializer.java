package Dashboard;

import java.time.LocalTime;

import Codes.*;
import Utils.*;

public class UserInitializer {

    private static final String waterStatsFile = "src/Txt_Files/water_stats.txt";
    private static final String feedbackFile = "src/Txt_Files/feedback.txt";
    PrintManager printManager = new PrintManager();
    private FileManager fileManager = new FileManager(printManager);
    private UserDashboard userDashboard = new UserDashboard();
    private User user;

    String username;
    LocalTime sleeptime,waketime,lastwatertaken;
    double dailygoal, currentintake;

    public void entercredentials() {
        System.out.println("\n                                                            ╔═════════════════════════════════════╗");
        System.out.println("                                                            ║           ENTER YOUR NAME           ║");
        System.out.println("                                                            ╚═════════════════════════════════════╝");

        username = MyGeneralUtils.takeInput("Enter name : ");
        
        System.out.println("Taking you to the dashbaord........");
        MyGeneralUtils.sleep(2000);
        
        MyGeneralUtils.clearTerminal();
        if(fileManager.userExistsInFile(waterStatsFile, username)==null) enterDetails();
        else extractDetails(username, fileManager.userExistsInFile(waterStatsFile, username));
    }

    private void enterDetails(){
        System.out.println("\n                                                            ╔═════════════════════════════════════╗");
        System.out.println("                                                            ║             ENTER DETAILS           ║");
        System.out.println("                                                            ╚═════════════════════════════════════╝");
        waketime = MyGeneralUtils.formatStringToTime(MyGeneralUtils.takeInput("Enter waking time : "));
        sleeptime = MyGeneralUtils.formatStringToTime(MyGeneralUtils.takeInput("Enter sleeping time : "));
        dailygoal = MyGeneralUtils.takeValidDoubleInput("Enter daily goal : ");
        user = new User(username, waketime, sleeptime, dailygoal, 0.0, waketime);

        fileManager.addUserStats(waterStatsFile, user);

        userDashboard.dashboard(user,waterStatsFile,feedbackFile);
    }

    private void extractDetails(String name, String details){
        String parts[] = details.split("\\|");

        waketime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.WAKE_TIME.getIndex()]);
        sleeptime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.SLEEP_TIME.getIndex()]);
        dailygoal = Double.parseDouble(parts[UserDataIndex.WATER_GOAL.getIndex()]);
        currentintake = Double.parseDouble(parts[UserDataIndex.CURRENT_TAKE.getIndex()]);
        lastwatertaken = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.LAST_WATER_TAKEN.getIndex()]);

        user = new User(name, waketime, sleeptime, dailygoal, currentintake, lastwatertaken);

        userDashboard.dashboard(user,waterStatsFile,feedbackFile);
    }
}
