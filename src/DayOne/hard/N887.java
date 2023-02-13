package DayOne.hard;

public class N887 {
    public int superEggDrop(int k, int n) {

        int[][] dp = new int[n + 1][k + 1];


        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
        }
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = dp[i][j - 1];
                for (int q = 1; q <= i; q++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[q - 1][j - 1], dp[i -q][j]) + 1);
                }
            }
        }
        return dp[n][k];
    }
    public int superEggDrop1(int k, int n) {

        int[][] dp = new int[n + 1][k + 1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1] + 1;
                if (dp[i][j] >= n){
                    return i;
                }
            }
        }
        return 0;
    }
}
