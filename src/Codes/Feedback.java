package Codes;

import Utils.Color;
import Utils.MyGeneralUtils;

public class Feedback {
    private final String feedbackFile;
    private User user;
    private FileManager fileManager;
    private PrintManager printManager;

    public Feedback(String feedbackFile, User user){
        this.feedbackFile = feedbackFile;
        this.user = user;
        this.printManager = new PrintManager();
        fileManager = new FileManager(printManager);
    }

    public void givefeedback(){
        System.out.println(
                "                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
                "                                                            █               FEEDBACK               █\n" +
                "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n");
        String feedback = MyGeneralUtils.takeInput(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Write feedback (hit enter to stop) : "+Color.RESET.getCode());
        fileManager.addUserFeedback(user, feedback, feedbackFile);
        System.out.println(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Your feedback sent successfully!!!"+Color.RESET.getCode());
    }

    public void viewAllFeedbacks(){
        System.out.println(
                "                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
                "                                                            █             ALL FEEDBACK             █\n" +
                "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n");
        fileManager.viewAllFeedback(feedbackFile);
    }
}
