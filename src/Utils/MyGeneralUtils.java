package Utils;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class MyGeneralUtils {
    
    private static final Scanner scanner =  new Scanner(System.in);

    public static String takeInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if(!input.isEmpty()){
                return input;
            }
        }
    }

    public static String takeUniqueInput(String filepath, String prompt) {
        while (true) {
            String input = takeInput(prompt);
            String searchResult = MyFileUtils.searchFromFile(filepath, input);
            if (searchResult == null) return input;
            else System.out.println("This email already exists! Please try again.");
        }
    }

    public static void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            // Thread.currentThread().interrupt();
            // System.out.println("Sleep interrupted: " + e.getMessage());
        }
    }

    public static String linesToString(List<String> lines){
        String output = "";
        for(String line : lines){
            output+=line+"\n";
        }
        return output;
    }

    public static LocalTime formatStringToTime(String time) {
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    } 
    
    public static String formatTimeToString(LocalTime time) {
        return time.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static LocalDate formatStringToDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yy"));
    }

    public static String formatDateToString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
    }

    public static double takeValidDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double input = Double.parseDouble(scanner.nextLine().trim());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static void clearTerminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {}
    }

}
