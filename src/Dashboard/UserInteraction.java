package Dashboard;

import java.time.LocalDate;
import java.time.LocalTime;

import Codes.User;
import Utils.FileUtils;
import Utils.TrackerUtils;

public class UserInteraction {

    private static final String filepath = "src/Txt_Files/water_stats.txt";
    public void userDashboard(){
        String name = TrackerUtils.takeInput("Enter your name : ");
        String email = TrackerUtils.takeInput("Enter your email : ");

        if(userExists(email)){
            //
        } else {
            haveToEnterDetails(name, email);
        }
    }

    private void haveToEnterDetails(String name, String email){
        String wakeTime = TrackerUtils.takeInput("Enter wake time : ");
        String sleepTime = TrackerUtils.takeInput("Enter sleep time : ");
        String dailygoal = TrackerUtils.takeInput("Enter daily goal : ");

        User user = new User(name, email, TrackerUtils.formatStringToTime(wakeTime), TrackerUtils.formatStringToTime(sleepTime), Double.parseDouble(dailygoal));
    }

    private boolean userExists(String email){
        String userresult = FileUtils.searchFromFile(filepath, email);

        String[] parts = userresult.split("\\|");
        LocalDate userDate = TrackerUtils.formatStringToDate(parts[FileUtils.dateIndex]);
        if(!userDate.equals(LocalDate.now())){
            return false;
        }
        
        LocalTime sleepTime = TrackerUtils.formatStringToTime(parts[FileUtils.sleepTimeIndex]);
        if(sleepTime.isBefore(LocalTime.now())){
            return false;
        }

        LocalTime wakeTime = TrackerUtils.formatStringToTime(parts[FileUtils.wakeTimeIndex]);
        if(wakeTime.isBefore(LocalTime.now())){
            return false;
        }
        else {
            return true;
        }

    }
}
