package DP;

/**
 * @author hdq
 * @create 2021-08-30 15:23
 */
public class N198 {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(0 + nums[1],dp[0]);
        if (nums.length <2){
            return dp[1];
        }
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        N198 n198 = new N198();
        int[] rob = {0};
        System.out.println(n198.rob(rob));
    }
}
