package App;
import About.About;
import Dashboard.*;
import Utils.*;

public class App {
    public static void main(String[] args) {
        MyGeneralUtils.clearTerminal();

        System.out.println(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"\n\n                                                                  WELCOME TO HYDRATION TRACKER\n"+Color.RESET.getCode());


        while (true) {
            System.out.println(
                "\n                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
                "                                                            █               YOUR ROLE              █\n" +
                "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" +
                "                                                            █          [1] Regular User            █\n" +
                "                                                            █          [2] Admin                   █\n" +
                "                                                            █          [3] About This App          █\n" +
                "                                                            █          [4] Exit                    █\n" +
                "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n");
            String choice = MyGeneralUtils.takeInput(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"Enter your choice : "+Color.RESET.getCode());
            switch (choice) {
                case "1":
                    new UserDashboard().dashboard();
                    break;
                case "2":
                    new AdminDashboard().dashbaord();
                    break;
                case "3":
                    new About().printGuide();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println(Color.RED.getCode()+Color.BOLD.getCode()+"Invalid choice."+Color.RESET.getCode());
                    break;
            }
        }
    }
}
