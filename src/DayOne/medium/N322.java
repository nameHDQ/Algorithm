package DayOne.medium;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-12-21 19:14
 */
public class N322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            if (coin <= amount){
                dp[coin] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {
                if (i-coin >=0 && dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }


    public int coinChange1(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount+1];

        if (amount == 0){
            return -1;
        }
        for (int i = 0; i <= coins.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] <= j){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount] == Integer.MAX_VALUE? -1:dp[coins.length][amount];
    }

    public static void main(String[] args) {
        N322 n322 = new N322();
        int[] arr = {1,2,5};
        System.out.println(n322.coinChange1(arr, 11));
    }
}
