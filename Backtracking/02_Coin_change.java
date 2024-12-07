public class CoinChangeBacktracking {
    public static int coinChange(int[] coins, int amount) {
        // Start the backtracking with amount and index 0 for coins array
        return backtrack(coins, amount, 0);
    }


    private static int backtrack(int[] coins, int remaining, int start) {
        // Base Case: If remaining amount is exactly 0, we found one valid way to make the change
        if (remaining == 0) return 1;
        
        // Base Case: If remaining amount is less than 0, this path is invalid
        if (remaining < 0) return 0;

        // To store the total ways for this particular recursion branch
        int totalWays = 0;

        // Try every coin starting from 'start' index
        for (int i = start; i < coins.length; i++) {
            // Recursively reduce the amount and explore further
            totalWays += backtrack(coins, remaining - coins[i], i); // Allow reusing the same coin
        }

        // Return total ways to make the change
        return totalWays;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println("Total ways to make change: " + coinChange(coins, amount)); // Output: 4
    }
}

Tracing :

Trace Explanation for coins = {1, 2, 5} and amount = 5:
The function explores all possible combinations of coins to make the amount 5.

Initial Call:

coinChange(coins, 5):
Calls backtrack(coins, 5, 0) (starting at index 0 with the full amount 5).
Detailed Backtracking Tree
Step 1: First Call - backtrack(coins, 5, 0)
Remaining amount is 5.
Choices:
Use 1 (first coin): Now call backtrack(coins, 5 - 1 = 4, 0).
Use 2 (second coin): Now call backtrack(coins, 5 - 2 = 3, 1).
Use 5 (third coin): Now call backtrack(coins, 5 - 5 = 0, 2).
Step 2: Exploring the path with coin 1
Call backtrack(coins, 4, 0)
  
Remaining amount is 4. Choices:
Use 1: Call backtrack(coins, 4 - 1 = 3, 0).
Use 2: Call backtrack(coins, 4 - 2 = 2, 1).
Use 5: Call backtrack(coins, 4 - 5 = -1, 2) (invalid path, returns 0).
Call backtrack(coins, 3, 0)
  
Remaining amount is 3. Choices:
Use 1: Call backtrack(coins, 3 - 1 = 2, 0).
Use 2: Call backtrack(coins, 3 - 2 = 1, 1).
Use 5: Call backtrack(coins, 3 - 5 = -2, 2) (invalid path, returns 0).
Call backtrack(coins, 2, 0)
  
Remaining amount is 2. Choices:
Use 1: Call backtrack(coins, 2 - 1 = 1, 0).
Use 2: Call backtrack(coins, 2 - 2 = 0, 1) (valid path, returns 1).
Use 5: Call backtrack(coins, 2 - 5 = -3, 2) (invalid path, returns 0).
Call backtrack(coins, 1, 0)
Remaining amount is 1. Choices:
Use 1: Call backtrack(coins, 1 - 1 = 0, 0) (valid path, returns 1).
Use 2: Call backtrack(coins, 1 - 2 = -1, 1) (invalid path, returns 0).
Use 5: Call backtrack(coins, 1 - 5 = -4, 2) (invalid path, returns 0).
                                             
Step 3: Exploring other coins from different indices
Other branches will explore using 2 and 5 to make up the amount.
For example, calling backtrack(coins, 5 - 5 = 0) will result in a valid path (1 way).
Similarly, using combinations of 1 and 2 will explore various paths.
Full Backtracking Path Summary
Paths found:

1 + 1 + 1 + 1 + 1 (5 ones).
1 + 1 + 1 + 2 (three ones, one two).
1 + 2 + 2 (one one, two twos).
5 (one five).
Total valid ways: 4 (as shown in the main output).

Total ways to make change: 4
