package DayOne;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-08-23 10:29
 */
public class N1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] nums = new int[n+1];
        nums[0] =0;
        nums[1] = 1;
        for (int i = 0; i <= n; i++) {
            if (2*i>=2 && 2*i<=n){
                nums[2*i] = nums[i];
            }
            if (2 * i + 1 >= 2 && 2 * i + 1<=n){
                nums[2 * i + 1] = nums[i] + nums[i + 1];
            }
        }
        Arrays.sort(nums);
        return nums[n];
    }

    public static void main(String[] args) {
        N1646 n1646 = new N1646();
        System.out.println(n1646.getMaximumGenerated(3));
    }
}
