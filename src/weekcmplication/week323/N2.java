package weekcmplication.week323;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N2 {
    public int longestSquareStreak(int[] nums) {

        Arrays.sort(nums);
        Map<Long, Integer> map = new HashMap<>();

        map.put(Long.valueOf(nums[nums.length - 1]),1);
        int maxLen = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            long temp = nums[i] * nums[i];
            if (map.containsKey(temp)){
                maxLen = Math.max(maxLen, map.get(temp) + 1);
                map.put((long) nums[i], map.get(temp) + 1);
            }else {
                map.put((long) nums[i],1);
            }
        }
        return maxLen;
    }
}
