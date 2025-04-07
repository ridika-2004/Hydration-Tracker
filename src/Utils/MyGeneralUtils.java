package Utils;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.regex.Pattern;

public class MyGeneralUtils {
    
    private static final Scanner scanner =  new Scanner(System.in);

    public static String takeInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if(!input.isEmpty()){
                return input;
            } else {
                System.out.println(Color.RED.getCode()+Color.BOLD.getCode()+"Input cannot be empty"+Color.RESET.getCode());
            }
        }
    }

    public static String takeTimeInput(String prompt){
        String timeRegex = "^([01]\\d|2[0-3]):([0-5]\\d)$";
        while (true) {
            String input = takeInput(prompt);
            if(Pattern.matches(timeRegex, input)) {
                return input;
            } else {
                System.out.println(Color.RED.getCode()+Color.BOLD.getCode()+"Invalid time format"+Color.RESET.getCode());
            }
        }
    }
    public static void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            // Thread.currentThread().interrupt();
            // System.out.println(e.getMessage());
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
                System.out.println(Color.RED.getCode()+Color.BOLD.getCode()+"Invalid input. Please enter a valid number."+Color.RESET.getCode());
            }
        }
    }

    public static void clearTerminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {}
    }

}
