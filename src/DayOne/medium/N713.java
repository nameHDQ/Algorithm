package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-08 14:06
 */
public class N713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int mul = 1;
        int count = 0;
        for (int i = 0,r =0 ; i < nums.length; ) {
            for (int j = i; j <= r ; j++) {
                mul *=nums[j];
            }
            if (mul < k){
                count++;
                r++;
                if (r>=nums.length){
                    i++;
                    r=i;
                }
                mul = 1;
            }else {
                i++;
                r=i;
                mul = 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        N713 n713 = new N713();
        int[] nums = {1,2,3};
        System.out.println(n713.numSubarrayProductLessThanK(nums, 0));
    }
}
