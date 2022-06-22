package DayOne.simple;

/**
 * @author hdq
 * @create 2022-03-10 14:17
 */
public class N303 {

    class NumArray {
        int[] preSum;
        public NumArray(int[] nums) {
            int n = nums.length;
            preSum = new int[n + 1];
            preSum[0] = 0;
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
