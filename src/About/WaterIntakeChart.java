package About;

public class WaterIntakeChart {

    public void displayAgeBasedChart() {
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                         Age-Based                       █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println("█ Age Group  █ Male (L) █ Female (L) █      Notes         █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println("█ 1-3 years  █   1.3    █    1.3     █ Includes  food     █");
        System.out.println("█ 4-8 years  █   1.7    █    1.7     █ -                  █");
        System.out.println("█ 9-13 years █   2.4    █    2.1     █ -                  █");
        System.out.println("█ 14-18 yrs  █   3.3    █    2.3     █ -                  █");
        System.out.println("█ 19-50 yrs  █   3.7    █    2.7     █ -                  █");
        System.out.println("█ 51+ years  █   3.7    █    2.7     █ -                  █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
    }

    public void displayWeightBasedChart() {
        System.out.println("\n▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                       Weight-Based                      █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println("█  Weight  █ Male (L) █ Female (L) █       Notes          █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println("█ < 50 kg  █   2.0    █   1.8      █ Adjust as needed     █");
        System.out.println("█ 50-70 kg █   2.5    █   2.2      █ -                    █");
        System.out.println("█ 70-90 kg █   3.0    █   2.7      █ -                    █");
        System.out.println("█ 90 + kg  █   3.5+   █   3.0+     █ Based on activity    █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
    }

    public void displaySpecialConditionChart() {
        System.out.println("\n▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█                    Special Conditions                   █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println("█ Condition  █ Male (L) █ Female (L) █        Notes       █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println("█ Pregnant   █   -      █   3.0      █ Extra 0.3L needed  █");
        System.out.println("█ Breastfeed █   -      █   3.8      █ Extra 1.1L needed  █");
        System.out.println("█ Athlete    █ +0.5-2.0 █ +0.5-2.0   █ Sweat loss varies  █");
        System.out.println("█ Hot Climate█ +0.5-1.5 █ +0.5-1.5   █ Higher sweating    █");
        System.out.println("█ Illness    █ +0.5-1.0 █ +0.5-1.0   █ Fever, diarrhea    █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n");
    }
}
