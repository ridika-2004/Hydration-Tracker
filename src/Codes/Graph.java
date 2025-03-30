package Codes;

public class Graph {
    
    public static void generateWaterIntakeGraph(double currentIntake, double waterGoal) {
        int totalBars = 20;
        int filledBars = (int) ((currentIntake / waterGoal) * totalBars);
        filledBars = Math.min(filledBars, totalBars);

        System.out.print("Water Intake Progress: [");
        for (int i = 0; i < filledBars; i++) {
            System.out.print("█");
        }
        for (int i = filledBars; i < totalBars; i++) {
            System.out.print("-");
        }
        System.out.println("] " + String.format("%.2f", (currentIntake / waterGoal) * 100) + "%");
    }
}
