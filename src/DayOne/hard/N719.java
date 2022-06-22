package DayOne.hard;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-06-15 9:37
 */
public class N719 {
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;
        int left = 0 , right = nums[n - 1] - nums[0];
        int ans = 0;
        while (left < right) {
            int mid = (left + right) >> 1;

            int i = 0; // 左指针
            int count = 0;

            for (int j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid){
                    i++;
                }
                count += j - i;
            }

            if (count >= k){
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
