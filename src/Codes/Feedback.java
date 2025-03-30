package Codes;

import Utils.MyGeneralUtils;

public class Feedback {
    private final String feedbackFile;
    private User user;
    private FileManager fileManager;

    public Feedback(String feedbackFile, User user){
        this.feedbackFile = feedbackFile;
        this.user = user;
        fileManager = new FileManager();
    }

    public void givefeedback(){
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                       Give Feedback                    █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n\n");
        String feedback = MyGeneralUtils.takeInput("Write feedback (hit enter to stop) : ");
        fileManager.addUserFeedback(user, feedback, feedbackFile);
        System.out.println("Your feedback sent successfully!!!");
    }

    public void viewAllFeedbacks(){
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                       All Feedback                     █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n\n");
        fileManager.viewAllFeedback(feedbackFile);
    }
}
