import java.util.*;

public class Main
{   

	public static void printPattern(int n){
        int i, j;
        for (i = n; i >= 1; i--) {           // outer loop to handle rows

            for (j = 0; j <= i; j++) {       // inner loop to handle columns
                System.out.print(" ");
            }
            
            for (j = 0; j <= n-i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
    
    public static void main(String[] args) {
		int n = 6;
        	printPattern(n);
    }
}

OUTPUT : 
       *
      **
     ***
    ****
   *****
  ******
