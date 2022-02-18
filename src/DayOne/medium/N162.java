package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-05 12:26
 */
public class N162 {
    public int findPeakElement(int[] nums) {
        int inx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[inx]){
                inx = i;
            }
        }
        return inx;
    }
}
