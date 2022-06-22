package weekcmplication.doubleweek78;

/**
 * @author hdq
 * @create 2022-05-14 22:37
 */
public class N2 {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        long allSum = 0;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            allSum += nums[i];
        }
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            long rightSum = allSum - preSum[i + 1];
            if (preSum[i + 1] >= rightSum) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new N2().waysToSplitArray(new int[]{2,3,1,0}));
    }
}
