package DayOne.medium;

public class N152 {
    public int maxProduct(int[] nums) {

        int m = nums.length;
        int[] dpMin = new int[m];
        int[] dpMax = new int[m];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < m; i++) {
            dpMax[i] = Math.max(nums[i],Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i],Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < m; i++) {
            int temp = Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]);
            res = Math.max(res, temp);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
