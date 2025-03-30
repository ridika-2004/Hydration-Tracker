package Dashboard;

import Codes.FileManager;
import Codes.User;
import Utils.MyGeneralUtils;

public class AdminDashboard {

    private static final String feedbackFile = "src/Txt_Files/feedback.txt";

    private void displayOptions(){
        System.out.println("[1] view all login");
        System.out.println("[2] see feedbacks");
    }
    public void dashbaord(){
        
        FileManager fileManager = new FileManager();
        while (true) {
            displayOptions();
            String choice = MyGeneralUtils.takeInput("Enter your choice : ");

            switch (choice) {
                case "2":
                    fileManager.viewAllFeedback(feedbackFile);
                    break;
            
                default:
                    break;
            }
        }
    }
}
