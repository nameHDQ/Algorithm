package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-31 13:37
 */
public class N1004 {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int right = 0;
        int max = 0;
        int count = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
