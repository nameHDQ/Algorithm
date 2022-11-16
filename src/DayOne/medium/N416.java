package DayOne.medium;

import java.util.Arrays;

public class N416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int res = sum / 2;
        int[][] dp = new int[nums.length][res + 1];
        for (int i = 0; i <= res; i++) {
            if (i >= nums[0]){
                dp[0][i] = nums[0];
            }

        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= res; j++) {
                if (j < nums[i]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[ i- 1][j - nums[i - 1]] + nums[i]);
                }

            }
        }
        return dp[nums.length - 1][res] == res;
    }

}
