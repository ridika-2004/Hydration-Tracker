package App;

import java.time.LocalDate;

import About.About;
import Codes.Tracker;
import Dashboard.UserInteraction;
import Utils.*;

public class App {
    public static void main(String[] args) {
        About about = new About();
        about.printGuide();
        // new UserInteraction().userDashboard();
        System.exit(0);
        // final String BLUE_TEXT = "\u001B[36m";  // Cyan text
        // final String RESET = "\u001B[0m";      // Reset color

        // // System.out.println(BLUE_TEXT + "Welcome to HydraTrack!" + RESET);

        // String[] waveFrames = {
        //     "██████████                 ",
        //     " ████████                  ",
        //     "  ██████                   ",
        //     "   ████                    ",
        //     "                           ",
        //     "                           "
        // };

        // for (int i = 0; i < 20; i++) {  // Repeat the animation
        //     System.out.print("\r" + waveFrames[i % waveFrames.length]); // Overwrite same line
        //     try {
        //         Thread.sleep(300);
        //     } catch (InterruptedException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     } // Delay to make it animate
        // }
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
