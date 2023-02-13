package DayOne.medium;

public class N215 {
    public int findKthLargest(int[] nums, int k) {
        int res = fastSort(nums, 0, nums.length - 1, nums.length - k);
        return res;
    }

    public int fastSort(int[] nums, int left, int right, int k){
        if (left == right){
            return nums[k];
        }
        int x = nums[left], l = left - 1, r = right + 1;
        while (l < r){
            do {
                l++;
            }while (nums[l] < x);
            do {
                r--;
            }while (nums[r] > x);

            if (l < r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        if (r < k){
            return fastSort(nums, r + 1, right, k);
        }else {
            return fastSort(nums, left, r, k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        new N215().findKthLargest(nums, 4);
    }
}
