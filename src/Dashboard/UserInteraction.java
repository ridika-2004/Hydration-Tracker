package Dashboard;

import java.time.LocalDate;
import java.time.LocalTime;

import Codes.FileManager;
import Codes.Graph;
import Codes.Reminder;
import Codes.Tracker;
import Codes.User;
import Utils.*;

public class UserInteraction {

    private static final String waterStatsFile = "src/Txt_Files/water_stats.txt";
    private static final String feedbackFile = "src/Txt_Files/feedback.txt";

    FileManager fileManager = new FileManager();
    public void userDashboard(){
        String name = MyGeneralUtils.takeInput("Enter your name : ");
        String email = MyGeneralUtils.takeInput("Enter your email : ");

        if(userExists(email)){
            String userresult = MyFileUtils.searchFromFile(waterStatsFile, email);
            String[] parts = userresult.split("\\|");
            LocalTime waketime = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.wakeTimeIndex]);
            LocalTime sleeptime = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.sleepTimeIndex]);
            double dailygoal = Double.parseDouble(parts[MyFileUtils.waterGoalIndex]);
            double currentIntake = Double.parseDouble(parts[MyFileUtils.currentTakeIndex]);
            LocalTime lastwatertaken = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.lastWaterTakenIndex]);

            User user = new User(name, email, waketime, sleeptime, dailygoal, currentIntake, lastwatertaken);

            
            // tracker.trackWater();
            Reminder reminder = new Reminder();
            Tracker tracker = new Tracker(waterStatsFile,user);
            Graph graph = new Graph(user);
            //tracker.trackWater();
            graph.generateWaterIntakeGraph();
            // reminder.startReminders(tracker.needsReminder());
            // MyGeneralUtils.sleep();

            // System.out.println("done");

            // System.out.println("Do you want to add water? ");
            // System.out.println(user.getLastWaterTaken());
        } else {
            haveToEnterDetails(name, email);
        }
    }

    private void haveToEnterDetails(String name, String email){
        String wakeTime = MyGeneralUtils.takeInput("Enter wake time : ");
        String sleepTime = MyGeneralUtils.takeInput("Enter sleep time : ");
        double dailygoal = MyGeneralUtils.takeValidDoubleInput("Enter daily goal : ");

        User user = new User(name, email, MyGeneralUtils.formatStringToTime(wakeTime), MyGeneralUtils.formatStringToTime(sleepTime), dailygoal, 0.0, MyGeneralUtils.formatStringToTime(wakeTime));
        fileManager.addUserStats(waterStatsFile, user);

        Reminder reminder = new Reminder();
        Tracker tracker = new Tracker(waterStatsFile,user);
        // tracker.trackWater();
        reminder.startReminders(tracker.needsReminder());
    }

    private boolean userExists(String email){
        String userresult = MyFileUtils.searchFromFile(waterStatsFile, email);
        // System.out.println(userresult);

        if(userresult==null){
            return false;
        }

        String[] parts = userresult.split("\\|");
        LocalDate userDate = MyGeneralUtils.formatStringToDate(parts[MyFileUtils.dateIndex]);
        if(!userDate.equals(LocalDate.now())){
            return false;
        }
        
        LocalTime sleepTime = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.sleepTimeIndex]);
        if(sleepTime.isBefore(LocalTime.now())){
            return false;
        }

        LocalTime wakeTime = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.wakeTimeIndex]);
        if(wakeTime.isAfter(LocalTime.now())){
            return false;
        }
        else {
            // System.out.println("ok");
            return true;
        }

    }
}
