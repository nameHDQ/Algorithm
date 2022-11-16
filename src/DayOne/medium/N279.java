package DayOne.medium;

import java.util.Arrays;

public class N279 {
    public int numSquares(int n) {
        int len = (int) Math.sqrt(n);
        int[][] dp = new int[len + 1][n + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1000000);
        }
        dp[0][0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= i * i){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i * i] + 1);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[len][n];
    }

    public static void main(String[] args) {
        new N279().numSquares(12);
    }
}
