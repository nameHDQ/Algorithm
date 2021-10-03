package DayOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hdq
 * @create 2021-09-08 18:14
 */
public class N502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Integer> availableR = new ArrayList<>();
        int[] dp = new int[capital.length];
        for (int i = 0; i < k; i++) {
            //找到满足条件的所有项目
            for (int j = 0; j < capital.length; j++) {
                if (capital[j] <= w && dp[j] ==0 ){
                    availableR.add(j);
                }
            }
            int maxProfit = 0;
            int index = 0;
            //找到满足项目的最大利润
            for (int j = 0; j < availableR.size(); j++) {
                if (profits[availableR.get(j)] >= maxProfit){
                    maxProfit = profits[availableR.get(j)];
                    index = availableR.get(j);
                }
            }
            //更新
            dp[index] =1;
            w+=maxProfit;
            availableR.clear();
        }
        return w;
    }

    public static void main(String[] args) {
        N502 n502 = new N502();
        int[] profits = {1,2,3};
        int[] capital = {0,1,2};
        System.out.println(n502.findMaximizedCapital(3, 0, profits, capital));
    }
}
