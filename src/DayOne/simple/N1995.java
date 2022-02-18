package DayOne.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hdq
 * @create 2021-12-29 11:47
 */
public class N1995 {
    public int countQuadruplets(int[] nums) {
        int n =  nums.length;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int c = n-2; c>=2  ; c--) {
            map.put(nums[c+1],map.getOrDefault(nums[c+1],0)+1);
            for (int a = 0; a < c; a++) {
                for (int b = a+1; b < c; b++) {
                    ans+=map.getOrDefault(nums[a]+nums[b]+nums[c],0);
                }
            }
        }
        return ans;
    }
}
