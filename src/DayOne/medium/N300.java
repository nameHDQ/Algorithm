package DayOne.medium;

import java.util.Stack;
import java.util.function.DoublePredicate;

/**
 * @author hdq
 * @create 2021-12-19 14:33
 */
public class N300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1){
            return 1;
        }
        int maxLen = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen = Math.max(dp[i],maxLen);
        }
        return maxLen;
    }

    public int lengthOfLIS1(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
