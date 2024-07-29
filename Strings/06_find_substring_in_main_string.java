import java.util.Scanner;

public class Solution {

    public boolean hasSubstring(String str1, String str2) {           // Method to check if str1 contains str2
        return str1.contains(str2);
    }

    public static void main(String[] args) {
      
        Solution solution = new Solution();                           // Create an instance of Solution
        Scanner scanner = new Scanner(System.in);                     // Read the main string from the user
        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();
        System.out.print("Enter the substring: ");                    // Read the substring from the user
        String subString = scanner.nextLine();

        // Check if the main string contains the substring using the hasSubstring method
        boolean result = solution.hasSubstring(mainString, subString);

        // Print the result
        if (result) {
            System.out.println("The main string contains the substring.");
        } else {
            System.out.println("The main string does not contain the substring.");
        }
        scanner.close();
    }
}
