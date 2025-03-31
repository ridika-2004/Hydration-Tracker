package Dashboard;
import Codes.*;
import Utils.*;

public class AdminDashboard {

    private static final String waterStatsFile = "src/Txt_Files/water_stats.txt";
    private static final String feedbackFile = "src/Txt_Files/feedback.txt";

    private void displayOptions() {
        System.out.println(
            "                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
            "                                                            █              ADMIN MENU              █\n" +
            "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" +
            "                                                            █           [1] View all login         █\n" +
            "                                                            █           [2] See feedbacks          █\n" +
            "                                                            █           [3] Exit                   █\n" +
            "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n");
    }    

    public void dashbaord(){
        
        PrintManager printManager = new PrintManager();
        FileManager fileManager = new FileManager(printManager);
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
