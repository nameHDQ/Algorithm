package DayOne.medium;

import DayOne.simple.N53;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-06-16 12:10
 */
public class N532 {
    public int findPairs(int[] nums, int k) {


        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (nums[mid] - nums[i] == k) {
                    res++;
                    break;
                }
                if (nums[mid] - nums[i] > k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {  3, 1, 4, 1, 5};
        System.out.println(new N532().findPairs(nums, 2));
    }
}
