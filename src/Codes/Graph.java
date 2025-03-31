package Codes;

public class Graph {
    private User user;
    private final int percentage_multiplier = 100;

    String darkBlue = "\u001B[34m";
    String reset = "\u001B[0m";

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
            System.out.print(darkBlue + "▓" + reset);
        }

        System.out.println("] " + String.format("%.2f", (user.getCurrentIntake() / user.getWaterGoal()) * percentage_multiplier) + "%");

        if(user.getCurrentIntake()>=user.getWaterGoal()) System.out.println("GOAL FULLFILLED");
    }
}
