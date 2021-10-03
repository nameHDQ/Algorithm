package DayOne;

import java.security.cert.X509Certificate;
import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-09-15 9:22
 */
public class N162 {
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[idx]){
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        N162 n162 = new N162();
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(n162.findPeakElement(nums));
    }
}
