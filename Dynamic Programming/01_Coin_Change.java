import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Step 1: Initialize dp array
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Fill dp with a large value
        dp[0] = 0; // Base case: no coins needed to make amount 0

        // Step 2: Fill dp array

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // Step 3: Return the result
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum coins needed: " + cc.coinChange(coins, amount)); // Output: 3
    }
}


// Approach : 2

public static int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0 || amount <= 0)
        return 0;

    int[] minNumber = new int[amount + 1];

    // Initialize the array with a large value for all amounts
    for (int i = 1; i <= amount; i++) {
        minNumber[i] = Integer.MAX_VALUE;
        
        // Loop over all coins and calculate the minimum number of coins
        for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE) {
                minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
            }
        }
    }

    // Return the result for the target amount
    return minNumber[amount] == Integer.MAX_VALUE ? -1 : minNumber[amount];
}


Example Tracing:

For amount = 1:

Using coin 1:
minNumber[1] = Math.min(minNumber[1], minNumber[1 - 1] + 1)
minNumber[1] = Math.min(Integer.MAX_VALUE, 0 + 1) → minNumber[1] = 1
For amount = 2:

Using coin 2:
minNumber[2] = Math.min(minNumber[2], minNumber[2 - 2] + 1)
minNumber[2] = Math.min(Integer.MAX_VALUE, 0 + 1) → minNumber[2] = 1

Using coin 1:
minNumber[2] = Math.min(minNumber[2], minNumber[2 - 1] + 1)
minNumber[2] = Math.min(1, 1 + 1) → minNumber[2] = 1
For amount = 3:

Using coin 1:
minNumber[3] = Math.min(minNumber[3], minNumber[3 - 1] + 1)
minNumber[3] = Math.min(Integer.MAX_VALUE, 1 + 1) → minNumber[3] = 2

Using coin 2:
minNumber[3] = Math.min(minNumber[3], minNumber[3 - 2] + 1)
minNumber[3] = Math.min(2, 1 + 1) → minNumber[3] = 2
Continuing this way for all amounts, we get the final minNumber array:

Final minNumber Array
Amount	Minimum Coins Needed
0	            0
1	            1
2	            1
3	            2
4	            2
5	            1
6	            2
7	            2
8	            3
9	            4
10	            2
11	            3

-----------------------------------------------------------------------------------
| Amount | Coins Used    | Calculation                          | minNumber Value |
|--------|---------------|--------------------------------------|-----------------|
| 0      | -             | -                                    | 0               |
| 1      | 1             | 1 coin of 1                          | 1               |
| 2      | 2             | 1 coin of 2                          | 1               |
| 3      | 1, 2          | 1 coin of 1 + 1 coin of 2            | 2               |
| 4      | 2             | 2 coins of 2                         | 2               |
| 5      | 5             | 1 coin of 5                          | 1               |
| 6      | 5, 1          | 1 coin of 5 + 1 coin of 1            | 2               |
| 7      | 5, 2          | 1 coin of 5 + 1 coin of 2            | 2               |
| 8      | 5, 2, 1       | 1 coin of 5 + 3 coins of 1           | 3               |
| 9      | 5, 2, 2       | 1 coin of 5 + 4 coins of 1           | 3               |
| 10     | 5, 5          | 2 coins of 5                         | 2               |
| 11     | 5, 5, 1       | 2 coins of 5 + 1 coin of 1           | 3               |
-----------------------------------------------------------------------------------
    ## Trace Table for Each Iteration

| Iteration | Current Amount (`i`) | Coin (`coin`) | `minNumber[i - coin]` | Calculation                                | `minNumber[i]` (Updated) |
|-----------|----------------------|---------------|-----------------------|--------------------------------------------|--------------------------|
| -         | 0                    | -             | -                     | Base case (0 coins needed for 0)           | 0                        |
| 1         | 1                    | 1             | 0                     | `minNumber[1] = min(minNumber[1], 1 + 0)`  | 1                        |
| 1         | 1                    | 2, 5          | N/A                   | Coins larger than current amount           | 1                        |
| 2         | 2                    | 1             | 1                     | `minNumber[2] = min(minNumber[2], 1 + 1)`  | 2                        |
| 2         | 2                    | 2             | 0                     | `minNumber[2] = min(minNumber[2], 1 + 0)`  | 1                        |
| 2         | 2                    | 5             | N/A                   | Coins larger than current amount           | 1                        |
| 3         | 3                    | 1             | 1                     | `minNumber[3] = min(minNumber[3], 1 + 1)`  | 2                        |
| 3         | 3                    | 2             | 1                     | `minNumber[3] = min(minNumber[3], 1 + 1)`  | 2                        |
| 3         | 3                    | 5             | N/A                   | Coins larger than current amount           | 2                        |
| 4         | 4                    | 1             | 2                     | `minNumber[4] = min(minNumber[4], 1 + 2)`  | 3                        |
| 4         | 4                    | 2             | 1                     | `minNumber[4] = min(minNumber[4], 1 + 1)`  | 2                        |
| 4         | 4                    | 5             | N/A                   | Coins larger than current amount           | 2                        |
| 5         | 5                    | 1             | 2                     | `minNumber[5] = min(minNumber[5], 1 + 2)`  | 3                        |
| 5         | 5                    | 2             | 2                     | `minNumber[5] = min(minNumber[5], 1 + 2)`  | 3                        |
| 5         | 5                    | 5             | 0                     | `minNumber[5] = min(minNumber[5], 1 + 0)`  | 1                        |
| 6         | 6                    | 1             | 1                     | `minNumber[6] = min(minNumber[6], 1 + 1)`  | 2                        |
| 6         | 6                    | 2             | 2                     | `minNumber[6] = min(minNumber[6], 1 + 2)`  | 2               |
| 6         | 6                    | 5             | 1                     | `minNumber[6] = min(minNumber[6], 1 + 1)`  | 2               |
| 7         | 7                    | 1             | 2                     | `minNumber[7] = min(minNumber[7], 1 + 2)`  | 3               |
| 7         | 7                    | 2             | 1                     | `minNumber[7] = min(minNumber[7], 1 + 1)`  | 2                |
| 7         | 7                    | 5             | 2                     | `minNumber[7] = min(minNumber[7], 1 + 2)`  | 2               |
| 8         | 8                    | 1             | 2                     | `minNumber[8] = min(minNumber[8], 1 + 2)`  | 3               |
| 8         | 8                    | 2             | 2                     | `minNumber[8] = min(minNumber[8], 1 + 2)`  | 3               |
| 8         | 8                    | 5             | 3                     | `minNumber[8] = min(minNumber[8], 1 + 3)`  | 3               |
| 9         | 9                    | 1             | 3                     | `minNumber[9] = min(minNumber[9], 1 + 3)`  | 4               |
| 9         | 9                    | 2             | 2                     | `minNumber[9] = min(minNumber[9], 1 + 2)`  | 3               |
| 9         | 9                    | 5             | 2                     | `minNumber[9] = min(minNumber[9], 1 + 2)`  | 3               |
| 10        | 10                   | 1             | 3                     | `minNumber[10] = min(minNumber[10], 1 + 3)`| 4               |
| 10        | 10                   | 2             | 2                     | `minNumber[10] = min(minNumber[10], 1 + 2)`| 2              |
| 10        | 10                   | 5             | 1                     | `minNumber[10] = min(minNumber[10], 1 + 1)`| 2              |
| 11        | 11                   | 1             | 2                     | `minNumber[11] = min(minNumber[11], 1 + 2)`| 3              |
| 11        | 11                   | 2             | 3                     | `minNumber[11] = min(minNumber[11], 1 + 3)`| 3              |
| 11        | 11                   | 5             | 2                     | `minNumber[11] = min(minNumber[11], 1 + 2)`| 3              |

## Final `minNumber` Array:

`minNumber = [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3]`

- For amount `11`, the minimum number of coins required is `3` (coins: 5, 5, 1).
