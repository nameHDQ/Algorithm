package DayOne.medium;

import java.util.Arrays;

public class N198 {
    public int rob(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (nums.length == 1) return nums[0];
        int[][] dp = new int[nums.length][ sum + 1];


        for (int j = 0; j <= sum; j++) {
            if (j >= nums[0]){
                dp[0][j] = nums[0];
            }
        }
        for (int j = 0; j <= sum; j++) {
            if (j >= nums[1]){
                dp[1][j] = Math.max(dp[0][j],  nums[1]);
            }else {
                dp[1][j] = dp[0][j];
            }
        }



        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i]){
                    dp[i][j] = Math.max(dp[i- 1][j], dp[i - 2][j] + nums[i]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        new N198().rob(nums);
    }
}
