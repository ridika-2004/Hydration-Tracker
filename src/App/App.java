package App;

import java.time.LocalDate;

import Dashboard.UserInteraction;
import Utils.FileUtils;
import Utils.TrackerUtils;

public class App {
    public static void main(String[] args) {
        new UserInteraction().userDashboard();
        // System.out.println(
        // "                                                            ╔═════════════════════════════════════╗\n" +
        // "                                                            ║           CHOOSE YOUR ROLE          ║\n" +
        // "                                                            ╠═════════════════════════════════════╣\n" +
        // "                                                            ║          [1] Regular User           ║\n" +
        // "                                                            ║          [2] Organizer              ║\n" +
        // "                                                            ║          [3] Exit                   ║\n" +
        // "                                                            ╚═════════════════════════════════════╝");

        // System.out.println("████████████████████████\r\n" + //
        //                 "█    CHOOSE OPTION    █\r\n" + //
        //                 "████████████████████████\r\n" + //
        //                 "█  [1] Start         █\r\n" + //
        //                 "█  [2] Settings      █\r\n" + //
        //                 "█  [3] Exit          █\r\n" + //
        //                 "████████████████████████\r\n" + //
        //                 "");
    }
}
