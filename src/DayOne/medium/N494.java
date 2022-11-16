package DayOne.medium;

import java.util.Arrays;

public class N494 {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = Arrays.stream(nums).sum();
        if ((target + sum) < 0 || (target + sum) % 2 != 0) return 0;
        int capacity = (target + sum) / 2;

        int[][] dp = new int[nums.length + 1][ capacity + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j < nums[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }

        }
        return dp[nums.length][capacity];
    }

    public static void main(String[] args) {
        System.out.println( (-5) % 2);
    }
}
