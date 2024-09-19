public class Solution {

    static void staircase(int n) {
        // Outer loop controls the rows, iterating from 1 to n
        for (int i = 1; i <= n; i++) {
            // Inner loop controls the columns, iterating from n down to 1
            for (int j = n; j > 0; j--) {
                // If the column index j is greater than the current row index i, print a space
                if (j > i) {
                    System.out.print(" ");
                } else {
                    // Otherwise, print a hash symbol ("#")
                    System.out.print("#");
                }
            }
            // Move to the next line after printing each row
            System.out.println();
        }
    }
}

output : 
  4

   #
  ##
 ###
####
