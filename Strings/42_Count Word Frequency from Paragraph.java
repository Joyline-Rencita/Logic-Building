import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "This is a test. This test is simple!";
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        String[] words = text.split("\\s+");
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        freq.entrySet().stream()
            .sorted((a, b) -> {
                int cmp = Integer.compare(b.getValue(), a.getValue());
                return cmp == 0 ? a.getKey().compareTo(b.getKey()) : cmp;
            })
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
