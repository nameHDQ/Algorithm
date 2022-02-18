package DayOne.simple;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-01-07 12:10
 */
public class N217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0){
            return false;
        }
        if (nums.length == 1){
            return true;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
