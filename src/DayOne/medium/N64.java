package DayOne.medium;

public class N64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = grid[0][0];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i ==1 && j == 1){
                    continue;
                }
                if (i == 1){
                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                    continue;
                }
                if (j == 1){
                    dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i - 1][j - 1], dp[i][j - 1] + grid[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }
}
