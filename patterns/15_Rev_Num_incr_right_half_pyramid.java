public class Main {
    public static void printPattern(int n)
    {
        int i, j;
        for (i = n; i >= 1; i--) {                 // outer loop to handle number of rows
            for (j = 1; j <= i; j++) {                // inner loop to handle number of columns
                System.out.print(j + " ");              // printing column values upto the row value.
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
1 2 3 4 5 6 
1 2 3 4 5 
1 2 3 4 
1 2 3 
1 2 
1 
