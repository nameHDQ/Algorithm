package DayOne.medium;

public class N714 {
    public int maxProfit(int[] prices, int fee) {


        int[][] dp = new int[prices.length][3];
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i] - fee);
        }
        return dp[prices.length - 1][2];
    }
}
