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
