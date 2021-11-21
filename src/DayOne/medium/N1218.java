package DayOne.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hdq
 * @create 2021-11-05 10:34
 */
public class N1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int v : arr) {
            map.put(v, map.getOrDefault(v-difference, 0)+1);
            ans = Math.max(ans, map.get(v));
        }
        return ans;
    }

    public static void main(String[] args) {
        N1218 n1218 = new N1218();
        int[] arr = {1,5,7,8,5,3,4,2,1};
        System.out.println(n1218.longestSubsequence(arr, -2));
    }
}
