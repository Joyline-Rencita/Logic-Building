import java.util.*;

public class Solution {
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList();
        int aScore = 0;
        int bScore = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                aScore++;
            } else if (b.get(i) > a.get(i)) {
                bScore++;
            }
        }
        result.add(aScore);
        result.add(bScore);
        return result;
    }
}
