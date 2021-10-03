package DayOne;

/**
 * @author hdq
 * @create 2021-08-19 12:18
 */
public class N704 {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        N704 n704 = new N704();
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(n704.search(nums, 2));
    }
}
