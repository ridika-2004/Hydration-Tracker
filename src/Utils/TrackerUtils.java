package Utils;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class TrackerUtils {
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

    public static String linesToString(List<String> lines){
        String output = "";
        for(String line : lines){
            output+=line+"\n";
        }
        return output;
    }

    public static void sleep(){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {}
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
