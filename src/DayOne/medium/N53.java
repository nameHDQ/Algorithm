package DayOne.medium;

import java.lang.management.MemoryUsage;

public class N53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int temp =nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 大于0 无脑加
            if (nums[i] >= 0){
                // 如果当前为0
                if(res <=0){
                    res = nums[i];
                    temp = 0;
                }
                temp += nums[i];
                res = Math.max(temp, res);
            }else {
                // 小于零 分情况
                // 如果总和小于零，没必要加了
                if (res < 0){
                    res = Math.max(res, nums[i]);
                    temp = nums[i];
                }else {
                    if (temp + nums[i] > 0){
                        temp += nums[i];
                    }else {
                        temp = 0;
                    }
                }
            }
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        int res = nums[0];

        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
