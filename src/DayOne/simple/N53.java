package DayOne.simple;

/**
 * @author hdq
 * @create 2022-01-07 13:13
 */
public class N53 {
    public int maxSubArray(int[] nums) {
        int pre = 0,maxNum = nums[0];
        for (int num : nums) {
            pre = Math.max(pre+num, num);
            maxNum = Math.max(maxNum, pre);
        }
        return maxNum;
    }
}
