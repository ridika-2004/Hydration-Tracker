package App;
import Dashboard.*;
import Utils.*;

public class App {
    public static void main(String[] args) {
        MyGeneralUtils.clearTerminal();

        while (true) {
            System.out.println(
                "                                                            ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
                "                                                            █               YOUR ROLE              █\n" +
                "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" +
                "                                                            █          [1] Regular User            █\n" +
                "                                                            █          [2] Admin                   █\n" +
                "                                                            █          [3] Exit                    █\n" +
                "                                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n");
            String choice = MyGeneralUtils.takeInput("Enter your choice : ");
            switch (choice) {
                case "1":
                    new UserDashboard().dashboard();
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
    }
}
