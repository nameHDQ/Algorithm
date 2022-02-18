package DayOne.simple;

import java.util.Arrays;
import java.util.List;

/**
 * @author hdq
 * @create 2022-01-07 13:31
 */
public class N1 {
    public int[] twoSum(int[] nums, int target) {
        long sum;
        for (int i = 0,j = nums.length-1; i!=j;) {
            sum  = nums[i]+nums[j];
            if (sum >target){
                j--;
            }else if (sum <target){
                i++;
            }else {
                return new int[]{i,j};
            }
        }
        return null;
    }
}
