package Codes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileManager {
    public static void saveStats(User user) {
        try (FileWriter writer = new FileWriter("src/water_stats.txt", true)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String stat = user.getName() + "|" + LocalDate.now().format(formatter) + "|" + user.getWakeTime() + "|" 
                            + user.getSleepTime() + "|" + user.getWaterGoal() + "|" + user.getCurrentIntake() + "\n";
            writer.write(stat);
            System.out.println("Stats saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving stats: " + e.getMessage());
        }
    }

    public static void readStats(User user) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Name", "Date", "Water Goal (ml)", "Water Intake (ml)", "Status");

        try (BufferedReader reader = new BufferedReader(new FileReader("src/water_stats.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 4 && user.getName().equalsIgnoreCase(data[0])) {
                    String name = data[0];
                    String date = data[1];
                    String waterGoal = data[2];
                    String waterIntake = data[3];
                    String status = Double.parseDouble(waterIntake) >= Double.parseDouble(waterGoal) ? "Goal Met" : "Goal Not Met";
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", name, date, waterGoal, waterIntake, status);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading stats: " + e.getMessage());
        }
    }
}
