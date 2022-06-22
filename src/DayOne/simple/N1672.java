package DayOne.simple;

/**
 * @author hdq
 * @create 2022-04-14 10:52
 */
public class N1672 {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int i = 0; i < accounts.length; i++) {
            int tem = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                tem += accounts[i][j];
            }
            res = Math.max(res, tem);
        }
        return res;
    }
}
