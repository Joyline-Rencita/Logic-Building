import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();                                 // Read number of test cases
        scanner.nextLine();                                        // Consume the newline character
        
        while (t-- > 0) {
            String a = scanner.nextLine();                       // Read the first string
            String b = scanner.nextLine();                      // Read the second string
            
            int l = a.length();                                 // Get the length of the first string
            
            // Generate the two possible rotations of the first string
            String a1 = a.substring(2) + a.substring(0, 2);                           // Rotate by moving the first two characters to the end
            String a2 = a.substring(l - 2) + a.substring(0, l - 2);                     // Rotate by moving the last two characters to the beginning
            
            // Check if either rotation matches the second string
            if (a1.equals(b) || a2.equals(b)) {
                System.out.println(1);                                     // Print 1 if there is a match
            } else {
                System.out.println(0);                                      // Print 0 if there is no match
            }
        } 
        scanner.close();  
    }
}
