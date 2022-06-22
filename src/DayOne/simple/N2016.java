package DayOne.simple;

/**
 * @author hdq
 * @create 2022-02-26 9:11
 */
public class N2016 {
    public int maximumDifference(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]){
                    int temp = nums[j] - nums[i];
                    if (temp > max) {
                        max = temp;
                    }
                }

            }
        }
        return max;
    }
}
