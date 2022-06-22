package DayOne.simple;

/**
 * @author hdq
 * @create 2022-03-10 16:17
 */
public class N1413 {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        int startValue = 0;
        for (int i = 0; i < n; i++) {
            preSum[i] = i==0?nums[i]:preSum[i-1]+nums[i];
            if (preSum[i] < 1) {
                startValue += 1 - preSum[i];
                preSum[i] += 1 - preSum[i];

            }
        }
        return startValue == 0 ? 1 : startValue;
    }

    public static void main(String[] args) {
        System.out.println(new N1413().minStartValue(new int[]{1,-2,-3}));
    }
}
