package DayOne.simple;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-01-13 12:02
 */
public class N747 {
    public int dominantIndex(int[] nums) {
        if (nums.length<2){
            return 0;
        }
        int idx1 = 0;
        int idx2 = 0;
        int first = nums[0];
        int second = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > first){
                first = nums[i];
                idx1 = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == first) {
                continue;
            }
            if (nums[i] > second && nums[i] < first){
                second = nums[i];
                idx2 = i;
            }
        }
        if (first >= second *2)return idx1;
        return -1;
    }

    public static void main(String[] args) {
        N747 n747 = new N747();
        int[] nums = {1,0};
        System.out.println(n747.dominantIndex(nums));
    }
}
