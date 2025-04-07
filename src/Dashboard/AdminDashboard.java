package Dashboard;
import Codes.*;
import Utils.*;

public class AdminDashboard {

    private static final String waterStatsFile = "src/Txt_Files/water_stats.txt";
    private static final String feedbackFile = "src/Txt_Files/feedback.txt";
    PrintManager printManager = new PrintManager();
        public void dashbaord(){
        
        PrintManager printManager = new PrintManager();
        FileManager fileManager = new FileManager(printManager);
        while (true) {
            printManager.adminOptionDisplay();
            String choice = MyGeneralUtils.takeInput(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Enter your choice : "+Color.RESET.getCode());

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
                    System.out.println(Color.RED.getCode()+Color.BOLD.getCode()+"Invalid choice."+Color.RESET.getCode());
                    break;
            }
        }
    }
}
