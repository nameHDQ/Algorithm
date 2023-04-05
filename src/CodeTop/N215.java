package CodeTop;

public class N215 {
    public int findKthLargest(int[] nums, int k) {
        int res = fastSort(0, nums.length- 1 ,nums, nums.length - k);
        return res;
    }


    public int fastSort(int left, int right, int[] nums, int k){
        if (left == right){
            return nums[k];
        }
        int l = left - 1, r = right + 1, x = nums[(left + right) >> 1];

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
        }if (r < k){
            return fastSort(r + 1, right, nums, k);

        }else {
            return fastSort(left, r, nums, k);
        }
    }

    public static void main(String[] args) {
        int[]num = {3,2,1,5,6,4};
        System.out.println(new N215().findKthLargest(num, 2));
    }
}
