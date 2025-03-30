package Dashboard;

import Codes.FileManager;
import Utils.MyGeneralUtils;

public class AdminDashboard {

    private static final String waterStatsFile = "src/Txt_Files/water_stats.txt";
    private static final String feedbackFile = "src/Txt_Files/feedback.txt";

    private void displayOptions(){
        System.out.println("[1] view all login");
        System.out.println("[2] see feedbacks");
        System.out.println("[3] exit");
    }
    public void dashbaord(){
        
        FileManager fileManager = new FileManager();
        while (true) {
            displayOptions();
            String choice = MyGeneralUtils.takeInput("Enter your choice : ");

            switch (choice) {
                case "1":
                    fileManager.viewAllLogin(waterStatsFile);
                    break;
                case "2":
                    fileManager.viewAllFeedback(feedbackFile);
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
