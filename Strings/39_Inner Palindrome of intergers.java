public class SimpleInnerPalindromes {

    public static void main(String[] args) {
        int num = 1234321;                         // Example number
        String str = Integer.toString(num);        // Convert number to string

        System.out.println("Inner palindromes in " + num + ":");

        for (int i = 0; i < str.length(); i++) {         // Start index
            for (int j = i + 2; j <= str.length(); j++) { // End index (min 2 digits)
                String sub = str.substring(i, j);         // Get substring
                if (isPalindrome(sub)) {                  // Check palindrome
                    System.out.println(sub);              // Print it
                }
            }
        }
    }

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;                            // Not a palindrome
            }
            left++;
            right--;
        }
        return true;                                     // Is a palindrome
    }
}
