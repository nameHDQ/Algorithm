package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-21 12:50
 */
public class N343 {
    public int integerBreak(int n) {
        int curMax = 0;
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j*(i-j), j*dp[i-j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
