package Dashboard;

import java.time.LocalDate;
import java.time.LocalTime;
import About.*;
import Codes.*;
import Utils.*;

public class UserDashboard {

    static final String waterStatsFile = "src/Txt_Files/water_stats.txt";
    static final String feedbackFile = "src/Txt_Files/feedback.txt";
    PrintManager printManager = new PrintManager();
    FileManager fileManager = new FileManager(printManager);
    User user;

    String username;
    LocalTime sleeptime,waketime,lastwatertaken;
    double dailygoal, currentintake;

    public void entercredentials() {
        printManager.smallBoxDisplay("NAME");
        username = MyGeneralUtils.takeInput("Enter name : ");
        
        System.out.println("Taking you to the dashbaord........");
        MyGeneralUtils.sleep(2000);
        
        MyGeneralUtils.clearTerminal();
        if(userExistsInFile(waterStatsFile, username)==null) enterDetails();
        else extractDetails(username, userExistsInFile(waterStatsFile, username));

        dashboard(user, waterStatsFile, feedbackFile);
    }

    private void extractDetails(String name, String details){
        String parts[] = details.split("\\|");

        waketime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.WAKE_TIME.getIndex()]);
        sleeptime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.SLEEP_TIME.getIndex()]);
        dailygoal = Double.parseDouble(parts[UserDataIndex.WATER_GOAL.getIndex()]);
        currentintake = Double.parseDouble(parts[UserDataIndex.CURRENT_TAKE.getIndex()]);
        lastwatertaken = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.LAST_WATER_TAKEN.getIndex()]);

        user = new User(name, waketime, sleeptime, dailygoal, currentintake, lastwatertaken);
    }

    private void enterDetails(){
        printManager.smallBoxDisplay("DETAILS");
        waketime = MyGeneralUtils.formatStringToTime(MyGeneralUtils.takeInput("Enter waking time : "));
        sleeptime = MyGeneralUtils.formatStringToTime(MyGeneralUtils.takeInput("Enter sleeping time : "));
        dailygoal = MyGeneralUtils.takeValidDoubleInput("Enter daily goal : ");
        user = new User(username, waketime, sleeptime, dailygoal, 0.0, waketime);

        fileManager.addUserStats(waterStatsFile, user);
    }


    
    public void dashboard(User user, String waterstatsfile, String feedbackfile){

        Tracker tracker = new Tracker(waterstatsfile,user);
        Reminder reminder = new Reminder(tracker);

        while (true) {
            reminder.startReminders();

            printManager.userOptionsDisplay();
            String choice = MyGeneralUtils.takeInput("Enter your choice : ");
            switch (choice) {
                case "1":
                    tracker.trackWater();
                    break;
                case "2":
                    PrintManager printManager = new PrintManager();
                    new FileManager(printManager).readUserStats(waterstatsfile, user);
                    break;
                case "3":
                    new Graph(user).generateWaterIntakeGraph();
                    break;
                case "4":
                    new Feedback(feedbackfile, user).givefeedback();
                    break;            
                case "5":
                    System.out.println("[1] Display chart by age");
                    System.out.println("[2] Display chart by weight");
                    System.out.println("[3] Special conditions");

                    String displaychoice = MyGeneralUtils.takeInput("Enter your choice : ");
                    switch (displaychoice) {
                        case "1":
                            new WaterIntakeChart().displayAgeBasedChart();
                            break;
                        case "2":
                            new WaterIntakeChart().displayWeightBasedChart();
                            break;
                        case "3":
                            new WaterIntakeChart().displaySpecialConditionChart();
                            break;
                        default:
                            break;
                    }
                    break;
                case "6":
                    System.out.println("Exiting.......");
                    MyGeneralUtils.sleep(1000);
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!!!");
                    break;
            }
        }
        
    }
    
    private String userExistsInFile(String waterstatsfile, String name){
        String userresult = MyFileUtils.searchFromFile(waterstatsfile, name);
        if(userresult==null) return null;

        String[] parts = userresult.split("\\|");
        LocalDate userDate = MyGeneralUtils.formatStringToDate(parts[UserDataIndex.DATE.getIndex()]);
        if(!userDate.equals(LocalDate.now())) return null;
        
        LocalTime sleepTime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.SLEEP_TIME.getIndex()]);
        if(sleepTime.isBefore(LocalTime.now())) return null;

        LocalTime wakeTime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.WAKE_TIME.getIndex()]);
        if(wakeTime.isAfter(LocalTime.now())) return null;
        else return userresult;
    }
}
