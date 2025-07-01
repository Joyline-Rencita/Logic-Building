import java.util.*;

public class AgeBucket {
    public static void main(String[] args) {
        int[] ages = {5, 17, 22, 36, 42, 58, 65, 80};

        Map<String, Integer> buckets = new LinkedHashMap<>();
        buckets.put("Minor", 0);
        buckets.put("Adult", 0);
        buckets.put("Middle Age", 0);
        buckets.put("Senior", 0);

        for (int age : ages) {
            if (age < 18) buckets.put("Minor", buckets.get("Minor") + 1);
            else if (age <= 40) buckets.put("Adult", buckets.get("Adult") + 1);
            else if (age <= 60) buckets.put("Middle Age", buckets.get("Middle Age") + 1);
            else buckets.put("Senior", buckets.get("Senior") + 1);
        }

        for (String key : buckets.keySet()) {
            System.out.println(key + ": " + buckets.get(key));
        }
    }
}
