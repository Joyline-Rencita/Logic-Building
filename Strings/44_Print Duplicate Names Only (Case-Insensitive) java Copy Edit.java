import java.util.*;

public class DuplicateNames {
    public static void main(String[] args) {
        String[] names = {"John", "JOHN", "Sara", "john", "sara"};
        Map<String, Integer> freq = new TreeMap<>();

        for (String name : names) {
            String key = name.toLowerCase();
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(capitalize(entry.getKey()) + ": " + entry.getValue());
            }
        }
    }

    static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
