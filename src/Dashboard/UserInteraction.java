package Dashboard;
import java.time.*;
import java.util.*;

import Codes.User;
import Utils.*;

public class UserInteraction {

    String waterstatsfile = "src/Txt_Files/water_stats.txt";

    public void dashboard(){
        String name = TrackerUtils.takeInput("Enter your name: ");
        String email = TrackerUtils.takeInput("Enter your email: ");

        if(needToEnterAsNewUser(email)) showNewUserOptions(name, email);
        else {
            inputWater(email);
        }
    }

    private void inputWater(String email){
        while (true){
            String waterTaken = TrackerUtils.takeInput("Enter water intake in ml (or type 'exit' to stop): ");
            if(waterTaken.equalsIgnoreCase("exit")) break;
            try {
                double watertakenvalue = Double.parseDouble(waterTaken);
                updateStats(email,watertakenvalue);
            } catch (Exception e) {
                System.out.println("Input is invalid ");
            }
        }
    }

    public void showNewUserOptions(String name, String email){
        String waketime = TrackerUtils.takeInput("Enter waking up time (HH:mm): ");
        String sleeptime = TrackerUtils.takeInput("Enter sleeping up time (HH:mm): ");
        String dailywatergoal = TrackerUtils.takeInput("Enter daily water drinking goal (ml): ");

        double watergoal;

        while (true){
            try{
                watergoal = Double.parseDouble(dailywatergoal);
                break;
            } catch (Exception e){ 
                System.out.println("Input is invalid");
            }
        }

        User user = new User(name, email, TrackerUtils.formatStringToTime(waketime), TrackerUtils.formatStringToTime(sleeptime), watergoal);
        inputWater(email);


    }

    private void updateStats(String email, double watertaken){
        String userLine = FileUtils.searchFromFile(waterstatsfile, email);
        String parts[] = userLine.split("\\|");
        double currentWater = Double.parseDouble(parts[FileUtils.currentTakeIndex]);

        List<String> lines = FileUtils.readFromFile(waterstatsfile);
        String userLine2 = FileUtils.searchFromFile(waterstatsfile, email);
        for(String line: lines){
            if(line.equalsIgnoreCase(userLine2)){
                lines.remove(line);
            }
        }

        String newline = String.join("|", parts[FileUtils.userNameIndex], parts[FileUtils.emailIndex], parts[FileUtils.dateIndex], 
                            parts[FileUtils.wakeTimeIndex], parts[FileUtils.sleepTimeIndex], parts[FileUtils.waterGoalIndex],
                                Double.toString(currentWater), TrackerUtils.formatTimeToString(LocalTime.now()));

        lines.add(newline);
        String output = TrackerUtils.linesToString(lines);
        FileUtils.clearFile(waterstatsfile);
        FileUtils.saveInFile(waterstatsfile, output);

    }

    private boolean needToEnterAsNewUser(String email){
        String userLine = FileUtils.searchFromFile(waterstatsfile, email);
        if(userLine==null) return true;

        LocalDate currentDate = LocalDate.now();
        LocalTime currenTime = LocalTime.now();
        String parts[] = userLine.split("\\|");
        LocalDate userdate = TrackerUtils.formatStringToDate(parts[FileUtils.dateIndex]);
        LocalTime usersleeptime = TrackerUtils.formatStringToTime(parts[FileUtils.sleepTimeIndex]);

        if(currentDate!=userdate) return true;
        if(currenTime.isAfter(usersleeptime)) return true;
        else return false;
    }
}
