package weekcmplication.week256;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-08-29 10:31
 */
public class N5854 {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 1){
            return 0;
        }
        Arrays.sort(nums);
        int temp = 100000+1;
        int m = 0,l=0;
        int right = nums.length-1;
        int left = nums.length-k;
        while (left>=0){
            m = nums[right--];
            l = nums[left--];
            temp = Math.min(temp,m-l);

        }
        return temp;
    }

    public static void main(String[] args) {
        N5854 n5854 = new N5854();
        int[] nums = {9,4,1,7};
        System.out.println(n5854.minimumDifference(nums, 2));
    }
}
