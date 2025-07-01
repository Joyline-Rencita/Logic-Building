public class RangeOverlap {
    public static void main(String[] args) {
        int[][] ranges = {{10, 20}, {15, 25}, {30, 40}};

        for (int i = 0; i < ranges.length; i++) {
            for (int j = i + 1; j < ranges.length; j++) {
                if (ranges[i][1] >= ranges[j][0] && ranges[j][1] >= ranges[i][0]) {
                    System.out.println("[" + ranges[i][0] + "," + ranges[i][1] + "] overlaps with [" +
                            ranges[j][0] + "," + ranges[j][1] + "]");
                }
            }
        }
    }
}
