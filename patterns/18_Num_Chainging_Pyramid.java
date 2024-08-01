public class Main {
    public static void printPattern(int n)
    {
        int i, j;
        int num = 1;
        for (i = 1; i <= n; i++) {                         // outer loop to handle number of rows
            for (j = 1; j <= i; j++) {                     // inner loop to handle number of columns
                System.out.print(num + " ");                    // printing value of num in each iteration.
                num++;                                          // increasing the value of num.
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
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 
16 17 18 19 20 21
