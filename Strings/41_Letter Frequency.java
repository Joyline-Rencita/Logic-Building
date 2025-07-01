import java.util.*;

public class LetterFrequency {
    public static void main(String[] args) {
        String[] words = {"Alpha", "Bravo", "Charlie"};

        int[] freq = new int[26];

        for (String word : words) {
            word = word.toLowerCase();
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    freq[c - 'a']++;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                System.out.println((char)(i + 'A') + ": " + freq[i]);
            }
        }
    }
}
