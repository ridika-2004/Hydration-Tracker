package Dashboard;

import java.time.*;
import Codes.*;
import Utils.*;

public class UserSession {
    private final FileManager fileManager;
    private final String waterStatsFile;

    public UserSession(FileManager fileManager, String waterStatsFile) {
        this.fileManager = fileManager;
        this.waterStatsFile = waterStatsFile;
    }

    public User startSession() {
        System.out.println(
            "\n                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
            "                                                            █                  NAME                █\n" +
            "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n");
        String username = MyGeneralUtils.takeInput(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Enter name: "+Color.RESET.getCode());

        System.out.println(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Taking you to the dashboard..."+Color.RESET.getCode());
        MyGeneralUtils.sleep(2000);
        MyGeneralUtils.clearTerminal();

        String userData = userExistsInFile(waterStatsFile, username);
        if (userData == null) {
            return enterDetails(username);
        } else {
            return extractDetails(username, userData);
        }
    }

    private User extractDetails(String name, String details) {
        String[] parts = details.split("\\|");

        LocalTime wakeTime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.WAKE_TIME.getIndex()]);
        LocalTime sleepTime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.SLEEP_TIME.getIndex()]);
        double dailyGoal = Double.parseDouble(parts[UserDataIndex.WATER_GOAL.getIndex()]);
        double currentIntake = Double.parseDouble(parts[UserDataIndex.CURRENT_TAKE.getIndex()]);
        LocalTime lastWaterTaken = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.LAST_WATER_TAKEN.getIndex()]);

        return new User(name, wakeTime, sleepTime, dailyGoal, currentIntake, lastWaterTaken);
    }

    private User enterDetails(String username) {
        System.out.println(
            "\n                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
            "                                                            █               DETAILS                █\n" +
            "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n");
        LocalTime wakeTime = MyGeneralUtils.formatStringToTime(MyGeneralUtils.takeTimeInput(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Enter waking time: "+Color.RESET.getCode()));
        LocalTime sleepTime = MyGeneralUtils.formatStringToTime(MyGeneralUtils.takeTimeInput(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Enter sleeping time: "+Color.RESET.getCode()));
        double dailyGoal = MyGeneralUtils.takeValidDoubleInput(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Enter daily goal: "+Color.RESET.getCode());

        User newUser = new User(username, wakeTime, sleepTime, dailyGoal, 0.0, wakeTime);
        fileManager.addUserStats(waterStatsFile, newUser);
        return newUser;
    }

    private String userExistsInFile(String waterStatsFile, String name) {
        String userResult = MyFileUtils.searchFromFile(waterStatsFile, name);
        if (userResult == null) return null;

        String[] parts = userResult.split("\\|");
        LocalDate userDate = MyGeneralUtils.formatStringToDate(parts[UserDataIndex.DATE.getIndex()]);
        if (!userDate.equals(LocalDate.now())) return null;

        LocalTime sleepTime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.SLEEP_TIME.getIndex()]);
        if (sleepTime.isBefore(LocalTime.now())) return null;

        LocalTime wakeTime = MyGeneralUtils.formatStringToTime(parts[UserDataIndex.WAKE_TIME.getIndex()]);
        if (wakeTime.isAfter(LocalTime.now())) return null;

        return userResult;
    }
}
