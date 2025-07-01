import java.util.*;

public class MostFrequentName {
    public static void main(String[] args) {
        String[] names = {"Sara", "John", "Sara", "Mike", "John"};
        Map<String, Integer> freq = new HashMap<>();

        for (String name : names) {
            freq.put(name, freq.getOrDefault(name, 0) + 1);
        }

        int max = Collections.max(freq.values());

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey());
            }
        }
    }
}
