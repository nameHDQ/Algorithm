package DayOne.simple;

/**
 * @author hdq
 * @create 2022-04-28 18:41
 */
public class N905 {
    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                res[left++] = nums[i];
            }else {
                res[right--] = nums[i];
            }
        }
        return res;
    }
}
