package DayOne.medium;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class N518 {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]){
                    dp[i][j] += dp[i - 1][j];
                }else {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }

            }
        }
        return dp[len][amount];
    }
    public int change1(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]){
                    dp[j] += dp[j];
                }else {
                    dp[j] += dp[j] + dp[j - coins[i - 1]];
                }

            }
        }
        return dp[amount];
    }
}
