package DayOne;

/**
 * @author hdq
 * @create 2021-08-19 12:39
 */
public class N35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right){
            mid = left + (right -left)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] >target){
                right = mid-1;
            }else {
                left = mid+1;;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        N35 n35 = new N35();
        int[] nums = {1};
        System.out.println(n35.searchInsert(nums, 0));
    }
}
