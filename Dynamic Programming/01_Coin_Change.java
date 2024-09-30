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
