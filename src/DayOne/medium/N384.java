package DayOne.medium;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hdq
 * @create 2021-11-22 10:10
 */
class Solution {
    int[] temp;
    int[] nums;
    int n;
    public Solution(int[] nums) {
        n = nums.length;
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        this.nums = nums;
    }

    public int[] reset() {
        return temp;
    }

    public int[] shuffle() {
        for (int i = 0; i < n; i++) {
            int t = (int) (Math.random()*n);
            int temp_loc = nums[i];
            nums[i] = nums[t];
            nums[t] = temp_loc;
        }
        return nums;
    }
}
public class N384 {
    public static void main(String[] args) {
        int[] nums = {1};
        Solution solution = new Solution(nums);
        for (int i : solution.shuffle()) {
            System.out.println(i);
        }
    }
}
