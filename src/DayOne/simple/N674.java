package DayOne.simple;

public class N674 {
    public int findLengthOfLCIS(int[] nums) {

        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                dp[i] = dp[ i -1] + 1;
            }else {
                dp[i] = 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
