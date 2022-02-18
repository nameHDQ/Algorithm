package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-08 20:33
 */
public class N209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        N209 n209 = new N209();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(n209.minSubArrayLen(7, nums));
    }
}
