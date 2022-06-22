package DayOne.simple;

/**
 * @author hdq
 * @create 2022-03-10 17:07
 */
public class N1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] preSum = new int[56];
        // 等差数组初始化
        for (int[] range : ranges) {
            preSum[range[0]]++;
            preSum[range[1] + 1]--;
        }
        // 前缀和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] += preSum[i - 1];
            if (i >= left && i <= right) {
                if (preSum[i] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
