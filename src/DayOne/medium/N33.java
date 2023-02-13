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
    public int search1(int[] nums, int target) {
        int len = nums.length;
        if (len == 1 ){
            if (nums[0] == target){
                return 1;
            }else {
                return -1;
            }
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] == target){
                return mid;
            }
            // 左侧有序
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                // 左侧无序
                // 答案在右侧
                if (nums[mid] < target && target <= nums[right]){
                    left = mid+1;
                }else {
                    //答案在左侧
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
