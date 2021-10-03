package DayOne;

/**
 * @author hdq
 * @create 2021-08-11 12:19
 * 二个问题：1可能有多个等差数列长度大于三
 * 2.多个等差数列而且长度不相等，那么子数列就更不想等
 *
 */
public class N413 {
    public static int numberOfArithmeticSlices(int[] nums) {
        int ans =0;
        if (nums.length < 3){
            return 0;
        }
        for (int i = 0; i < nums.length-1;) {
            int d = nums[i+1] - nums[i];
            int j =i;
            while (j+1 <nums.length && nums[j+1] - nums[j] ==d) j++;
            int len = j-i+1;
            if (len >=3){
                ans+= (len-3+1)*(1+len - 3+1)/2;
            }
            i = j;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,8,9,10};
        System.out.println(numberOfArithmeticSlices(a));
    }
}
