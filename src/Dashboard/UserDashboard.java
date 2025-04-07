package Dashboard;
import java.time.*;
import About.*;
import Codes.*;
import Interfaces.*;
import Utils.*;

public class UserDashboard {

    String waterStatsFile = "src/Txt_Files/water_stats.txt";
    String feedbackFile = "src/Txt_Files/feedback.txt";
    IPrintManager printManager = new PrintManager();
    IFileManager fileManager = new FileManager(printManager);
    User user;

    String username;
    LocalTime sleeptime,waketime,lastwatertaken;
    double dailygoal, currentintake;
    
    public void dashboard(){
        UserSession userSession = new UserSession(fileManager, waterStatsFile);
        user = userSession.startSession();

        ITracker tracker = new Tracker(waterStatsFile,user);
        Reminder reminder = new Reminder(tracker);

        while (true) {
            reminder.startReminders();

            printManager.userOptionsDisplay();
            String choice = MyGeneralUtils.takeInput(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Enter your choice : "+Color.RESET.getCode());
            switch (choice) {
                case "1":
                    tracker.trackWater();
                    break;
                case "2":
                    fileManager.readUserStats(waterStatsFile, user);
                    break;
                case "3":
                    new Graph(user).generateWaterIntakeGraph();
                    break;
                case "4":
                    new Feedback(feedbackFile, user).givefeedback();
                    break;            
                case "5":
                    printManager.displayChartOptions();
                    String displaychoice = MyGeneralUtils.takeInput(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Enter your choice : "+Color.RESET.getCode());
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
                    System.out.println(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Exiting......."+Color.RESET.getCode());
                    MyGeneralUtils.sleep(1000);
                    System.exit(0);
                default:
                    System.out.println(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Invalid choice!!!"+Color.RESET.getCode());
                    break;
            }
        }
        
    }
}
