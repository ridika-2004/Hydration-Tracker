package Codes;
import java.io.*;
import java.time.LocalDate;

import Utils.*;

public class FileManager {
    public static void addStats(String filepath, User user) {
        try (FileWriter writer = new FileWriter(filepath, true)) {
            String data = String.join("|", user.getName(),user.getEmail(),TrackerUtils.formatDateToString(LocalDate.now()),
                            TrackerUtils.formatTimeToString(user.getWakeTime()),TrackerUtils.formatTimeToString(user.getSleepTime()),
                            String.format("%.2f",user.getWaterGoal()),String.format("%.2f",user.getCurrentIntake()),
                            TrackerUtils.formatTimeToString(user.getLastWaterTaken()));
            writer.write(data+"\n");
            // System.out.println("Stats saved successfully.");
        } catch (IOException e) {
            // System.out.println("Error saving stats: " + e.getMessage());
        }
    }

    public static void updateStats(String filepath, User user){
        String userline = FileUtils.searchFromFile(filepath, user.getEmail());
        FileUtils.deleteLineFromFile(filepath, userline);
        addStats(filepath, user);
    }

    public static void saveStats( String filepath ,String details) {
        try (FileWriter writer = new FileWriter(filepath, true)) {
            writer.write(details);
            // System.out.println("Stats saved successfully.");
        } catch (IOException e) {
            // System.out.println("Error saving stats: " + e.getMessage());
        }
    }

    public static void readStats(String filepath, User user) {
        // System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Name", "Date", "Water Goal (ml)", "Water Intake (ml)", "Status");

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 4 && user.getName().equalsIgnoreCase(data[0])) {
                }
            }
        } catch (IOException e) {
            // System.out.println("Error reading stats: " + e.getMessage());
        }
    }
}
