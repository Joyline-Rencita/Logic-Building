public class Main {
    public static void printPattern(int n)
    {
        int i, j;
        int num = 1;
        
        for (i = 1; i <= n; i++) {                                 // outer loop to handle upper part
            for (j = 1; j <= n - i; j++) {                         // inner loop to print spaces
                System.out.print(" ");
            }
            for (j = 1; j <= 2 * i - 1; j++) {                      // inner loop to print stars
                if (j == 1 || j == 2*i-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        } 
        for (i = n-1; i >= 1; i--) {                                // outer loop to handle lower part
            for (j = 1; j <= n - i; j++) {                          // inner loop to print spaces
                System.out.print(" ");
            }
            for (j = 1; j <= 2 * i - 1; j++) {                        // inner loop to print stars
                if (j == 1 || j == 2*i-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        int n = 6;
        printPattern(n);
    }
}

Output : 
     *
    * *
   *   *
  *     *
 *       *
*         *
 *       *
  *     *
   *   *
    * *
     *
