package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-04 12:20
 */
public class N33 {
    public int search(int[] nums, int target) {
        int i = 0;
        for (int num : nums) {
            if (num == target) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
