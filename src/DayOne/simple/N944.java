package DayOne.simple;

/**
 * @author hdq
 * @create 2022-05-12 20:20
 */
public class N944 {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
