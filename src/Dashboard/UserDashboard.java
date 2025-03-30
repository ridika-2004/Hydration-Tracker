package Dashboard;

import java.time.LocalTime;
import About.*;
import Codes.*;
import Utils.*;

public class UserDashboard {

    String waterStatsFile = "src/Txt_Files/water_stats.txt";
    String feedbackFile = "src/Txt_Files/feedback.txt";
    PrintManager printManager = new PrintManager();
    FileManager fileManager = new FileManager(printManager);
    User user;

    String username;
    LocalTime sleeptime,waketime,lastwatertaken;
    double dailygoal, currentintake;
    
    public void dashboard(){

        UserSession userSession = new UserSession(fileManager, printManager, waterStatsFile);
        user = userSession.startSession();

        Tracker tracker = new Tracker(waterStatsFile,user);
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
                    new FileManager(printManager).readUserStats(waterStatsFile, user);
                    break;
                case "3":
                    new Graph(user).generateWaterIntakeGraph();
                    break;
                case "4":
                    new Feedback(waterStatsFile, user).givefeedback();
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
}
