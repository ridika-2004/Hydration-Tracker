package Codes;
import Utils.*;

public class Graph{
    private User user;
    private final int percentage_multiplier = 100;

    public Graph(User user){
        this.user = user;
    }
    public void generateWaterIntakeGraph() {
        int totalBars = 20;
        int filledBars = (int) ((user.getCurrentIntake() / user.getWaterGoal()) * totalBars);
        filledBars = Math.min(filledBars, totalBars);

        System.out.print("Water Intake Progress: [");
        for (int i = 0; i < filledBars; i++) {
            System.out.print("█");
        }

        for (int i = filledBars; i < totalBars; i++) {
            System.out.print(Color.DARK_BLUE.getCode() + "▓" + Color.RESET.getCode());
        }

        System.out.println("] " + String.format("%.2f", (user.getCurrentIntake() / user.getWaterGoal()) * percentage_multiplier) + "%");

        if(user.getCurrentIntake()>=user.getWaterGoal()) System.out.println(Color.MAGENTA.getCode()+Color.BOLD.getCode()+"GOAL FULLFILLED"+Color.RESET.getCode());
    }
}
