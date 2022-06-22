package competition.spring2022;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-04-16 15:02
 */
public class N1 {
    public int giveGem(int[] gem, int[][] operations) {
        int m = operations.length;
        for (int i = 0; i < m; i++) {
            int tem = gem[operations[i][0]] / 2;
            gem[operations[i][1]] += tem;
            gem[operations[i][0]] -= tem;
        }
        int max = Arrays.stream(gem).max().getAsInt();
        int min = Arrays.stream(gem).min().getAsInt();
        return max - min;
    }
}
