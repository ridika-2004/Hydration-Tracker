package Codes;
import java.util.*;

public class PrintManager {
    public void printFeedbackTable(List<String> lines, String filterUser) {
        System.out.println("                                          ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.printf("                                          █ %-20s█ %-60s █\n", "Name", "Feedback");
        System.out.println("                                          █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
    
        for (String line : lines) {
            String[] parts = line.split("\\|");
            String userName = parts[UserDataIndex.USER_NAME.getIndex()];
            String feedback = parts[UserDataIndex.FEEDBACK.getIndex()];
    
            if (filterUser == null || userName.equalsIgnoreCase(filterUser)) {
                System.out.printf("                                          █ %-20s█ %-60s █\n", userName, feedback);
            }
        }   
        System.out.println("                                          █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n\n"); 
    }


    public void printUserStats(List<String> lines, User user) {
        System.out.println("\n                    ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.printf("                    █ %-20s█ %-20s█ %-20s█ %-20s█ %-20s █\n", "Name", "Date", "Water Goal", "Current Intake", "Status");
        System.out.println("                    █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");

        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (!parts[UserDataIndex.USER_NAME.getIndex()].equalsIgnoreCase(user.getName())) continue;
            
            String status = "Goal not met";
            double watergoal = Double.parseDouble(parts[UserDataIndex.WATER_GOAL.getIndex()]);
            double intake = Double.parseDouble(parts[UserDataIndex.CURRENT_TAKE.getIndex()]);
            if (intake >= watergoal) status = "Goal Fulfilled"; 
            System.out.printf("                    █ %-20s█ %-20s█ %-20s█ %-20s█ %-20s █\n", parts[UserDataIndex.USER_NAME.getIndex()],parts[UserDataIndex.DATE.getIndex()],watergoal,intake,status);
        }
        System.out.println("                    ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n\n");
    }
    

    public void printLoginDetails(List<String> lines){              
        System.out.println("                                                        ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.printf("                                                        █ %-20s█ %-20s █\n", "Name", "Date");
        System.out.println("                                                        █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        for(String line : lines){
            String[] parts = line.split("\\|");
            System.out.printf("                                                        █ %-20s█ %-20s █\n", parts[UserDataIndex.USER_NAME.getIndex()], parts[UserDataIndex.DATE.getIndex()]);
        }
        System.out.println("                                                        █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n\n");
                                                                                      
    }

    public void adminOptionDisplay(){
        System.out.println(
            "                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
            "                                                            █              ADMIN MENU              █\n" +
            "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" +
            "                                                            █           [1] View all login         █\n" +
            "                                                            █           [2] See feedbacks          █\n" +
            "                                                            █           [3] Exit                   █\n" +
            "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n");
    }

    public void userOptionsDisplay(){
        System.out.println(
            "                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
            "                                                            █            DASHBOARD MENU            █\n" +
            "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" +
            "                                                            █          [1] Add water               █\n" +
            "                                                            █          [2] Your history            █\n" +
            "                                                            █          [3] Current stats           █\n" +
            "                                                            █          [4] Give feedback           █\n" +
            "                                                            █          [5] View water need chart   █\n" +
            "                                                            █          [6] Exit                    █\n" +
            "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n");
    }

    public void displayChartOptions() {
        System.out.println(
            "                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
            "                                                            █          WATER INTAKE CHART          █\n" +
            "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" +
            "                                                            █          [1] By Age                  █\n" +
            "                                                            █          [2] By Weight               █\n" +
            "                                                            █          [3] Special Conditions      █\n" +
            "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n"
        );
    }
    
}
