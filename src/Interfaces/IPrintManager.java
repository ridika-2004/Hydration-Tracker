package Interfaces;
import java.util.*;

import Codes.User;

public interface IPrintManager {
    void printFeedbackTable(List<String> lines, String filterUser);
    void printUserStats(List<String> lines, User user);
    void printLoginDetails(List<String> lines);
    void adminOptionDisplay();
    void userOptionsDisplay();
    void displayChartOptions();
}
