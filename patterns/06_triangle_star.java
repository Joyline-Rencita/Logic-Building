import java.util.*;

public class Solution {
    public static void printPattern(int n)
    {
        int i, j;
        for (i = 0; i < n; i++) {                // outer loop to handle rows
            for (j = n - i; j > 1; j--) {        // inner loop to print spaces.
                System.out.print(" ");
            }
            for (j = 0; j <= i; j++) {            // inner loop to print stars.
                System.out.print("* ");
            }
            System.out.println();                    // printing new line for each row
        }
    }
    public static void main(String args[])
    {
        int n = 6;
        printPattern(n);
    }
}

Solution : 
     * 
    * * 
   * * * 
  * * * * 
 * * * * * 
* * * * * * 
