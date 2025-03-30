package Dashboard;

import java.time.LocalTime;

import About.WaterIntakeChart;
import Codes.Feedback;
import Codes.FileManager;
import Codes.Graph;
import Codes.PrintManager;
import Codes.Reminder;
import Codes.Tracker;
import Codes.User;
import Codes.UserDataIndex;
import Utils.MyGeneralUtils;

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

    private void extractDetails(String name, String details){
        String parts[] = details.split("\\|");

        waketime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.WAKE_TIME.getIndex()]);
        sleeptime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.SLEEP_TIME.getIndex()]);
        dailygoal = Double.parseDouble(parts[UserDataIndex.WATER_GOAL.getIndex()]);
        currentintake = Double.parseDouble(parts[UserDataIndex.CURRENT_TAKE.getIndex()]);
        lastwatertaken = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.LAST_WATER_TAKEN.getIndex()]);

        user = new User(name, waketime, sleeptime, dailygoal, currentintake, lastwatertaken);
        dashboard(user,waterStatsFile,feedbackFile);
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

        dashboard(user,waterStatsFile,feedbackFile);
    }


    
    public void dashboard(User user, String waterstatsfile, String feedbackfile){
        entercredentials();

        Tracker tracker = new Tracker(waterstatsfile,user);
        Reminder reminder = new Reminder(tracker);

        while (true) {
            reminder.startReminders();

        displayOptions();
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

    private void displayOptions(){
        System.out.println("[1] Add water ");
        System.out.println("[2] Your history ");
        System.out.println("[3] Current stats ");
        System.out.println("[4] Give feedback ");
        System.out.println("[5] View standard water need chart");
        System.out.println("[6] Exit");
    }
}
