package DayOne.simple;

/**
 * @author hdq
 * @create 2022-04-30 10:29
 */
public class N908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        max = max - k;
        min = min + k;
        return max - min > 0 ? max - min : 0;
    }
}
