package About;
public class About {

    public static void printGuide() {
        System.out.println("===============================================");
        System.out.println("Welcome to the Hydration Tracker App!");
        System.out.println("===============================================");
        
        System.out.println("How to Use the Hydration Tracker:");
        System.out.println("1. Set up your profile");
        System.out.println("   - Enter your name, wake-up time, sleep time, and daily water intake goal.");
        
        System.out.println("2. Track your water intake");
        System.out.println("   - After setup, log each amount of water you drink throughout the day.");
        System.out.println("   - Enter the amount in milliliters (ml).");
        
        System.out.println("3. Receive reminders");
        System.out.println("   - The app will remind you to drink water if you haven't consumed enough in the last few hours.");
        
        System.out.println("4. View your progress");
        System.out.println("   - You can check your water intake and whether you've met your daily goal.");
        
        System.out.println("5. Save and check stats");
        System.out.println("   - The app saves your stats (name, date, water goal, and intake) in a text file.");
        System.out.println("   - You can view your stats with the 'readStats' function.");

        System.out.println("===============================================");
        System.out.println("To exit the app, type 'exit'. Stay hydrated!");
        System.out.println("===============================================");
    }
}
