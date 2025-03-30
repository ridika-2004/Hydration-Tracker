package Dashboard;

import About.WaterIntakeChart;
import Codes.Feedback;
import Codes.FileManager;
import Codes.Graph;
import Codes.Reminder;
import Codes.Tracker;
import Codes.User;
import Utils.MyGeneralUtils;

public class UserDashboard {

    private void displayOptions(){
        System.out.println("[1] Add water ");
        System.out.println("[2] Your history ");
        System.out.println("[3] Current stats ");
        System.out.println("[4] Give feedback ");
        System.out.println("[5] View standard water need chart");
        System.out.println("[6] Exit");
    }
    
    public void dashboard(User user, String waterstatsfile, String feedbackfile){

        Tracker tracker = new Tracker(waterstatsfile,user);
        Reminder reminder = new Reminder(tracker);

        while (true) {
            reminder.startReminders();

        displayOptions();
        String choice = MyGeneralUtils.takeInput("Enter your choice : ");
        switch (choice) {
            case "1":
                tracker.trackWater();
                break;
            case "2":
                new FileManager().readUserStats(waterstatsfile, user);
                break;
            case "3":
                new Graph(user).generateWaterIntakeGraph();
                break;
            case "4":
                new Feedback(feedbackfile, user).givefeedback();
                break;            
            case "5":
                System.out.println("[1] Display chart by age");
                System.out.println("[2] Display chart by weight");
                System.out.println("[3] Special conditions");

                String displaychoice = MyGeneralUtils.takeInput("Enter your choice : ");
                switch (displaychoice) {
                    case "1":
                        new WaterIntakeChart().displayAgeBasedChart();
                        break;
                    case "2":
                        new WaterIntakeChart().displayWeightBasedChart();
                        break;
                    case "3":
                        new WaterIntakeChart().displaySpecialConditionChart();
                        break;
                    default:
                        break;
                }
                break;
            case "6":
                System.out.println("Exiting.......");
                MyGeneralUtils.sleep(1000);
                System.exit(0);
            default:
                System.out.println("Invalid choice!!!");
                break;
        }
        }
        
    }
}
