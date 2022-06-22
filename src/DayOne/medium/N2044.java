package DayOne.medium;

import java.text.DateFormatSymbols;

/**
 * @author hdq
 * @create 2022-03-15 14:16
 */
public class N2044 {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        return  dfs(nums, 0, 0, max);
    }

    private int dfs(int[] nums, int curIndex, int curvalue, int max) {
        if (curIndex == nums.length) {
            return curvalue == max ? 1 : 0;
        }
        return dfs(nums, curIndex + 1, curvalue | nums[curIndex], max) + dfs(nums, curIndex + 1, curvalue, max);
    }

}
