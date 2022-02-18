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

    public static void main(String[] args) {
        N322 n322 = new N322();
        int[] arr = {2};
        System.out.println(n322.coinChange(arr, 3));
    }
}
