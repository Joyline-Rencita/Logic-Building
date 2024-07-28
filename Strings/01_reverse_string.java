public class Solution {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        // Split the string into an array of words using dots as the delimiter.
        String[] wordsArray = s.trim().split("\\.");  // Use regular expression to split by dots
        
        // Initialize a StringBuilder to build the reversed result.
        StringBuilder result = new StringBuilder();
        
        // Iterate through the array of words in reverse order, except the first word.
        for (int i = wordsArray.length - 1; i > 0; i--) {
            // Append each word followed by a dot.
            result.append(wordsArray[i]).append(".");   
        }
        
        // Append the first word without adding an extra dot.
        return result.append(wordsArray[0]).toString();
    }
}
