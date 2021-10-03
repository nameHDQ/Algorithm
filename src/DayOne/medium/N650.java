package DayOne.medium;

/**
 * @author hdq
 * @create 2021-09-19 9:44
 */
public class N650 {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n ; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j*j <=i ; j++) {
                if (i%j == 0){
                    dp[i] = Math.min(dp[i],dp[i-1] + i/j);
                    dp[i] = Math.min(dp[i],dp[i/j] + j);
                }
            }
        }

        return dp[n];
    }
}
