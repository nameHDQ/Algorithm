package DayOne.hard;

public class N121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPr = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPr){
                res = Math.max(prices[i] - minPr,res);
            }
            minPr = Math.min(prices[i], minPr);
        }



        return res;
    }
}
