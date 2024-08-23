public class Main {
    public static void printPattern(int n)
    {
        int i, j;
        for (i = 1; i <= n; i++) {                            // outer loop to handle number of rows
            for (j = 1; j <= 2 * (n - i); j++) {              // inner loop to print the spaces
                System.out.print(" ");
            }
            for (j = i; j >= 1; j--) {
                System.out.print(j + " ");                   // inner loop to print the first part ie the left side
            }
            for (j = 2; j <= i; j++) {
                System.out.print(j + " ");                   // inner loop to print the second part
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

Output
          1 
        2 1 2 
      3 2 1 2 3 
    4 3 2 1 2 3 4 
  5 4 3 2 1 2 3 4 5 
6 5 4 3 2 1 2 3 4 5 6 
