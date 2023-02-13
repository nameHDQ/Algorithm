package DayOne.hard;

public class N188 {
    public int maxProfit(int k, int[] prices) {

        int[][][] dp = new int[prices.length][k][3];
        // 0 没操作， 1 买入， 2 卖出
        for (int i = 0; i < k; i++) {
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                // 第一天
                if (j == 0){
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j][1] + prices[i]);
                }else {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2] - prices[i]);
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j][1] + prices[i]);
                }
            }
        }
        return dp[prices.length - 1][k - 1][2];
    }
}
