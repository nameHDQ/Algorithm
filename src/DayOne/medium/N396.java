package DayOne.medium;

/**
 * @author hdq
 * @create 2022-04-22 9:28
 */
public class N396 {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int max = 0;
        int f0 = 0;
        for (int i = 0; i < nums.length; i++) {
            f0 += i * nums[i];
        }
        max = f0;
        for(int i = 1; i < nums.length; i++){
            f0 = f0 + sum - nums.length * nums[nums.length - i];
            max = Math.max(max, f0);
        }
        return max;
    }

    public static void main(String[] args) {
        N396 n396 = new N396();
        int[] nums = {1,2,3,4};
        System.out.println(n396.maxRotateFunction(nums));
    }

}
