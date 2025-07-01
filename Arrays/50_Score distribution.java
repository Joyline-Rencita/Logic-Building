import java.util.*;

public class RangeDistribution {

    public static void main(String[] args) {
        int[] scores = {45, 67, 89, 90, 23, 55, 74, 95, 60, 100, 33};
        printScoreDistribution(scores);
    }

    public static void printScoreDistribution(int[] scores) {
        int fail = 0, average = 0, good = 0, excellent = 0;

        for (int score : scores) {
            if (score < 50) fail++;
            else if (score < 70) average++;
            else if (score < 90) good++;
            else excellent++;
        }

        System.out.println("Fail (0-49): " + fail);
        System.out.println("Average (50-69): " + average);
        System.out.println("Good (70-89): " + good);
        System.out.println("Excellent (90-100): " + excellent);
    }
}
