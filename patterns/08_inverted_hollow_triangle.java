import java.util.*;

public class Solution {
    public static void printPattern(int n)
    {
        int i, j;
        for (i = 1; i <= n; i++) {                           // outer loop to handle rows
            for (j = 1; j < i; j++) {                          // inner loop to print spaces.
                System.out.print(" ");
            }
            for (j = i; j <= n; j++) {                            // inner loop to print value of j.
                System.out.print(j + " ");
            }
            System.out.println();                            // printing new line for each row
        }
    }
    public static void main(String args[])
    {
        int n = 6;
        printPattern(n);
    }
}

SOLUTION : 
***********
 *       *
  *     *
   *   *
    * *
     *
