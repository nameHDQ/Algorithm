package DayOne.medium;

import java.util.Arrays;

public class N1049 {
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = Arrays.stream(stones).sum();
        int half = sum / 2;
        int[][] dp = new int[len][half + 1];
        for (int i = 0; i <= half; i++) {
            if (i >= stones[0]){
                dp[0][i] = stones[0];
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= half; j++) {
                if (j < stones[i]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }

            }
        }
        return sum - 2 * dp[len - 1][half];
    }
}
