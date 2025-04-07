package Interfaces;

import Codes.User;

public interface IFileManager {
    public void addUserStats(String waterStatsFilepath, User user);
    public void updateStats(String waterStatsFilepath, User user);
    public void readUserStats(String waterStatsFilepath, User user);
    public void addUserFeedback(User user, String feedback, String feedbackfile);
    public void viewAllFeedback(String feedbackFile);
    public void viewAllLogin(String waterstatsfile);
}
