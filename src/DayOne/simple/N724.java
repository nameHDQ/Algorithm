package DayOne.simple;

/**
 * @author hdq
 * @create 2022-03-10 14:24
 */
public class N724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        for (int i = 0; i < nums.length; i++) {
            preSum[i] = (i == 0 ? nums[i] : preSum[i - 1] + nums[i]);
        }
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 0 : preSum[i - 1];
            int right = i == n - 1 ? 0 : preSum[n - 1] - preSum[i];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
