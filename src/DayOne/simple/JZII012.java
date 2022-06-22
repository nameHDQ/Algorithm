package DayOne.simple;

/**
 * @author hdq
 * @create 2022-03-10 19:58
 */
public class JZII012 {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            preSum[i] = nums[i] + (i == 0 ? 0 : preSum[i - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            int left = i == 0 ? 0 : preSum[i - 1];
            int right = preSum[n - 1] - preSum[i];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
