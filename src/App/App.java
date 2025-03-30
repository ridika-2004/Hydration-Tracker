package App;

import Dashboard.AdminDashboard;
import Dashboard.UserDashboard;
import Dashboard.UserInitializer;
import Utils.MyGeneralUtils;

public class App {
    public static void main(String[] args) {

            while (true) {
                System.out.println(
                "                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
                "                                                            █                                      █\n" +
                "                                                            █           CHOOSE YOUR ROLE           █\n" +
                "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" +
                "                                                            █                                      █\n" +
                "                                                            █          [1] Regular User            █\n" +
                "                                                            █          [2] Admin                   █\n" +
                "                                                            █          [3] Exit                    █\n" +
                "                                                            █                                      █\n" +
                "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" +
                "                                                            ");
                String choice = MyGeneralUtils.takeInput("Enter your choice : ");
                switch (choice) {
                    case "1":
                        new UserInitializer().entercredentials();
                        break;
                    case "2":
                        new AdminDashboard().dashbaord();
                        break;
                    case "3":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        // final String BLUE_TEXT = "\u001B[36m";  // Cyan text
        // final String RESET = "\u001B[0m";      // Reset color

        // // System.out.println(BLUE_TEXT + "Welcome to HydraTrack!" + RESET);
        // System.out.println();

        // System.out.println(
        //     "                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
        //     "                                                            █                                      █\n" +
        //     "                                                            █           CHOOSE YOUR ROLE           █\n" +
        //     "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" +
        //     "                                                            █                                      █\n" +
        //     "                                                            █          [1] Regular User            █\n" +
        //     "                                                            █          [2] Organizer               █\n" +
        //     "                                                            █          [3] Exit                    █\n" +
        //     "                                                            █                                      █\n" +
        //     "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" +
        //     "                                                            ");
        
        
        

        // System.out.println("████████████████████████\r\n" + //
        //                 "█    CHOOSE OPTION    █\r\n" + //
        //                 "████████████████████████\r\n" + //
        //                 "█  [1] Start         █\r\n" + //
        //                 "█  [2] Settings      █\r\n" + //
        //                 "█  [3] Exit          █\r\n" + //
        //                 "████████████████████████\r\n" + //
        //                 "");

        // System.out.println("▄\n");

        // ██████████              
        //  ████████    
        //   ██████             
        //    ████
    }
}
