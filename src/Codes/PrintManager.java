package Codes;

import java.util.List;

public class PrintManager {
    public void printFeedbackTable(List<String> lines, String filterUser) {
        System.out.printf("%-20s%-20s\n", "Name", "Feedback");
    
        for (String line : lines) {
            String[] parts = line.split("\\|");
            String userName = parts[UserDataIndex.USER_NAME.getIndex()];
            String feedback = parts[UserDataIndex.FEEDBACK.getIndex()];
    
            if (filterUser == null || userName.equalsIgnoreCase(filterUser)) System.out.printf("%-20s%-20s\n", userName, feedback);
        }
    }    


    public void printUserStats(List<String> lines){
        for(String line : lines){
            String[] parts = line.split("\\|");
            String status = "Goal not met";
            double watergoal = Double.parseDouble(parts[UserDataIndex.WATER_GOAL.getIndex()]);
            double intake = Double.parseDouble(parts[UserDataIndex.CURRENT_TAKE.getIndex()]);
            if(intake>=watergoal) status = "Goal Fullfilled"; 
            System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", parts[UserDataIndex.USER_NAME.getIndex()], 
                                    parts[UserDataIndex.DATE.getIndex()], watergoal, intake, status);
        }
    }

    public void printLoginDetails(List<String> lines){
        for(String line : lines){
            String[] parts = line.split("\\|");
            System.out.printf("%-20s%-20s\n", parts[UserDataIndex.USER_NAME.getIndex()], 
                                parts[UserDataIndex.DATE.getIndex()]);
        }
    }
}
