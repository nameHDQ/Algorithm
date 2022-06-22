package DayOne.medium;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author hdq
 * @create 2022-03-04 11:01
 */
public class N2104 {
    public long subArrayRanges(int[] nums) {
        long min ;
        long max ;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            min = nums[i];
            max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        N2104 n2104 = new N2104();
        int[] nums = {1,3,3};
        System.out.println(n2104.subArrayRanges(nums));
    }
}
