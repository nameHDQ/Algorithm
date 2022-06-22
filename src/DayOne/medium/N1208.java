package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-31 13:14
 */
public class N1208 {
    public int equalSubstring(String s, String t, int maxCost) {

        int n = s.length();
        int left = 0;
        int right = 0;
        int res = 0;
        int cost = 0;
        while (right < n) {
            cost += Math.abs(s.charAt(right) - t.charAt(right));
            if (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            right++;
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
