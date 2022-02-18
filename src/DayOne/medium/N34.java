package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-04 11:52
 */
public class N34 {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        boolean first = true;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && first) {
                start = i;
                first = false;
            }else if (nums[i] == target){
                count++;
            }
        }
        int[] re = {start,start+count};
        return re;
    }

    public static void main(String[] args) {
        N34 n34 = new N34();
        int[] nums = {};
        for (int i : n34.searchRange(nums, 6)) {
            System.out.println(i);
        }
    }
}
