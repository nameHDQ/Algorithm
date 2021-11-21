package DayOne.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hdq
 * @create 2021-11-20 9:55
 */
public class N594 {
    public int findLHS(int[] nums) {
        int max_total = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int max = nums[i];
            int min = nums[i];
            int total = 0;
            for (int j = i+1; j <nums.length ; j++) {
                if (Math.abs(max - nums[j]) <=1){
                    int tem_max = Math.max(max,nums[j]);
                    int tem_min = Math.min(min,nums[j]);
                    if (tem_max - tem_min <=1){
                        max = tem_max;
                        min = tem_min;
                        total++;
                    }
                }
            }
            if (total>=max_total&&max - min == 1){
                max_total = total+1;
            }
        }

        return max_total;
    }

    public static void main(String[] args) {
        N594 n594 = new N594();
        int[] nums = {-3,-1,-1,-1,-3,-2};
        System.out.println(n594.findLHS(nums));
    }
}
