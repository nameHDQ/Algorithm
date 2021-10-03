package DayOne;

/**
 * @author hdq
 * @create 2021-08-20 11:50
 */
public class N189 {
    public void rotate(int[] nums, int k) {
        if (k == 0){
            return ;
        }
        int[] cnums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = i+k > nums.length-1 ? (i+k)%nums.length : i+k;
            cnums[index] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = cnums[i];
        }
    }
}
