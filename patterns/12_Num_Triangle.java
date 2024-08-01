public class Main {
    public static void printPattern(int n)
    {
        int i, j;
        for (i = 1; i <= n; i++) {                   // outer loop to handle number of rows
            for (j = 1; j <= n - i; j++) {               // inner loop to print space
                System.out.print(" ");
            }
            for (j = 1; j <= i; j++) {
                System.out.print(i + " ");                    // inner loop to print star
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
     1 
    2 2 
   3 3 3 
  4 4 4 4 
 5 5 5 5 5 
6 6 6 6 6 6
