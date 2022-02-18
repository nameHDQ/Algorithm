package DayOne.medium;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-12-05 12:03
 */
public class N153 {
    public int findMin(int[] nums) {
        for (int i = 0,j = i+1; i < nums.length-1; i++,j++) {
            if (nums[i]<nums[j]){
                continue;
            }else {
                return nums[j];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        N153 n153 = new N153();
        int[] arr ={0,1,2,4,5,6,7};
        System.out.println(n153.findMin(arr));
    }
}
