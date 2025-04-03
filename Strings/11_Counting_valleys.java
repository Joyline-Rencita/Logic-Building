public class Solution {
    public static int countingValleys(int steps, String path) {
        int valleysCount = 0;
        int seaLevel = 0;
        boolean valley = false;
        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') {
                seaLevel++;
            } else {
                seaLevel--;
            }
            if (!valley && seaLevel < 0) {
                valley = true;
                valleysCount++;
            } else if (seaLevel >= 0) {
                valley = false;
            }
        }
        return valleysCount;
    }
}
