package DayOne.simple;

/**
 * @author hdq
 * @create 2022-04-19 10:40
 */
public class N821 {
    public int[] shortestToChar(String s, char c) {
        int left = 100000;
        int right = 100000;
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                left = i;
                res[i] = 0;
            }else {
                res[i] = Math.abs(i - left);
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                right = i;
                res[i] = 0;
            }else {
                res[i] = Math.min(res[i], right - i);
            }
        }
        return res;
    }
}
