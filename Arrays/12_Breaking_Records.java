public class Solution {
    static int[] breakingRecords(int[] scores) {
        int minRecord = scores[0];
        int maxRecord = scores[0];
        int minRecordCount = 0;
        int maxRecordCount = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > maxRecord) {
                maxRecord = scores[i];
                maxRecordCount++;
            } else if (scores[i] < minRecord) {
                minRecord = scores[i];
                minRecordCount++;
            }
        }
        int[] record = new int[2];
        record[0] = maxRecordCount;
        record[1] = minRecordCount;
        return record;
    }
}
