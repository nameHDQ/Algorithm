package DayOne.medium;

import DayOne.N46;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-05-19 12:16
 */
public class N462 {
    public int minMoves2(int[] nums) {
        quick_sork(nums, 0, nums.length- 1);
        int n = nums.length, mid = nums[(n - 1) / 2], ans = 0;
        for (int num : nums) {
            ans += Math.abs(mid - num);
        }
        return ans;
    }

    public void quick_sork(int[] num, int left, int right){
        if (left >= right) return;
        int i = left - 1, j = right + 1, x = num[left + right >> 1];
        while (i < j){
            do i++; while (num[i] < x);
            do j--; while (num[j] > x);
            if (i < j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        quick_sork(num, left, j);
        quick_sork(num, j+1, right);
    }

    public static void main(String[] args) {
        int[] nums = {4,2,1,6,4,2,3,5,7,8,4,5,6};
        new N462().minMoves2(nums);
    }
}
