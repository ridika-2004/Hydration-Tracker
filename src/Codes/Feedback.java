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
        String feedback = MyGeneralUtils.takeInput("Write feedback (hit enter to stop) : ");
        fileManager.addUserFeedback(user, feedback, feedbackFile);
    }

    public void viewMyFeedbacks(){
        fileManager.viewUserFeedback(feedbackFile, user);
    }

    public void viewAllFeedbacks(){
        fileManager.viewAllFeedback(feedbackFile);
    }
}
