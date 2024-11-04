class Solution {
    public int longestPalindrome(String s) {
        // Create an array to count occurrences of each character.
        // The ASCII value of a character will be used as the index.
        int[] charCounts = new int[128];
        for (int i = 0; i < s.length(); i++) {
            // Count each character's occurrences.
            charCounts[s.charAt(i)]++;
        }

        int lengthOfLongestPalindrome = 0;
        for (int count : charCounts) {
            // Add the largest even number below or equal to the current character count.
            // This is equivalent to count - (count % 2).
            lengthOfLongestPalindrome += count - (count & 1);

            // If the current palindrome length is even and the count is odd,
            // we can add one more character to the center of the palindrome.
            if (lengthOfLongestPalindrome % 2 == 0 && count % 2 == 1) {
                lengthOfLongestPalindrome++;
            }
        }
        // Return the length of the longest possible palindrome.
        return lengthOfLongestPalindrome;
    }
}
