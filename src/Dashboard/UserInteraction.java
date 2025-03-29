package Dashboard;

import java.time.LocalDate;
import java.time.LocalTime;

import Codes.FileManager;
import Codes.Reminder;
import Codes.Tracker;
import Codes.User;
import Utils.*;

public class UserInteraction {

    private static final String filepath = "src/Txt_Files/water_stats.txt";
    public void userDashboard(){
        String name = MyGeneralUtils.takeInput("Enter your name : ");
        String email = MyGeneralUtils.takeInput("Enter your email : ");

        if(userExists(email)){
            String userresult = MyFileUtils.searchFromFile(filepath, email);
            String[] parts = userresult.split("\\|");
            LocalTime waketime = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.wakeTimeIndex]);
            LocalTime sleeptime = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.sleepTimeIndex]);
            double dailygoal = Double.parseDouble(parts[MyFileUtils.waterGoalIndex]);
            double currentIntake = Double.parseDouble(parts[MyFileUtils.currentTakeIndex]);
            LocalTime lastwatertaken = MyGeneralUtils.formatStringToTime(parts[MyFileUtils.lastWaterTakenIndex]);

            User user = new User(name, email, waketime, sleeptime, dailygoal, currentIntake, lastwatertaken);

            Tracker tracker = new Tracker(filepath,user);
            // tracker.trackWater();
            Reminder reminder = new Reminder(tracker);
            reminder.startReminders();

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
        FileManager.addStats(filepath, user);

        Tracker tracker = new Tracker(filepath,user);
        // tracker.trackWater();
        Reminder reminder = new Reminder(tracker);
        reminder.startReminders();
    }

    private boolean userExists(String email){
        String userresult = MyFileUtils.searchFromFile(filepath, email);
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
