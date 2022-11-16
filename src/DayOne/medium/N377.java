package DayOne.medium;

import java.util.Arrays;

public class N377 {
    int res = 0;
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target];
        Arrays.fill(dp,-1);
        res = backTrack(nums, 0, target);
        return res;
    }

    int  backTrack(int[] nums, int sum, int target){
        if (sum == target){
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if (sum + nums[i] <= target){


                if (dp[sum + nums[i]] == -1){
                    int temp = backTrack(nums, sum + nums[i], target);
                    dp[sum + nums[i]] = temp;
                }
                res += dp[sum + nums[i]];
            }
        }
        return res;
    }
    public int combinationSum3(int[] nums, int target) {
        int[][] dp = new int[target + 1][target + 1];
        dp[0][0] = 1;
        int ans = 0;
        // 最多target个组合
        for (int i = 1; i <= target; i++) {
            // 组合和结果为target的
            for (int j = 0; j <= target; j++) {

                for (int num : nums) {
                    if (num <= j){
                        dp[i][j] += dp[i - 1][j - num];
                    }
                }
            }
            ans += dp[i][target];
        }
        return ans;
    }


}
