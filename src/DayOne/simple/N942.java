package DayOne.simple;

/**
 * @author hdq
 * @create 2022-05-09 13:38
 */
public class N942 {


    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        int i = 0, j = n;
        for (int k = 0; k < n; k++) {
            if (s.charAt(k) == 'I') {
                res[k] = i++;
            }
            if (s.charAt(k) == 'D') {
                res[k] = j--;
            }
        }
        res[n] = i;
        return res;
    }
}
