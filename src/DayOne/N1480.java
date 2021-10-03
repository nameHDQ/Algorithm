package DayOne;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-08-28 13:48
 */
public class N1480 {
    public int[] runningSum(int[] nums) {
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            total += nums[i];
            nums[i] =  total;
        }

        return nums;
    }

    public static void main(String[] args) {
        N1480 n1480 = new N1480();
        int[] nums = {3,1,2,10,1};
        System.out.println(Arrays.toString(n1480.runningSum(nums)));
    }
}
