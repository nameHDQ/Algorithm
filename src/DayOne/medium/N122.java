package DayOne.medium;

public class N122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int res = 0;


        int buy = prices[0];
        int temp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                temp = Math.max(temp, prices[i] - buy);
            }else {
                buy = prices[i];
                res += temp;
                temp = 0;
            }
        }
        return res;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length == 1) return 0;

        int res = 0;

        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
