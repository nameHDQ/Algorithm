package weekcmplication.week294;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-05-22 10:40
 */
public class N3 {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (x, y) ->
                x[0] - y[0]
        );
        int n = stockPrices.length;
        if (n == 1) return 0;
        if (n <= 2) return 1;
        int tempX = stockPrices[1][0] - stockPrices[0][0];
        int tempY = stockPrices[1][1] - stockPrices[0][1];
        int ans = 1;
        for (int i = 2; i < n; i++) {
            int x = stockPrices[i][0] - stockPrices[i - 1][0];
            int y = stockPrices[i][1] - stockPrices[i - 1][1];
            if (x == tempX && y == tempY) continue;
            // tempY  != 0
            if (tempY != 0){
                if (y == 0) {
                    ans++;
                    tempX = x;
                    tempY = y;
                    continue;
                }else {
                    // y != 0 && tempY != 0
                    if ((tempX % x == 0 && tempY % y == 0 && tempX / x == tempY / y)
                            || (x % tempX == 0 && y % tempY == 0 && x / tempX == y / tempY)) {
                        tempX = x;
                        tempY = y;
                        continue;
                    }else {
                        ans++;
                        tempX = x;
                        tempY = y;
                        continue;
                    }
                }
            }else {
                // tempY  == 0
                if (y != 0) {
                    ans++;
                    tempX = x;
                    tempY = y;
                    continue;
                }else {
                    // tempY  == 0 && y == 0
                    if ((tempX % x == 0 ) || (x % tempX == 0)) {
                        continue;
                    }else {
                        ans++;
                        tempX = x;
                        tempY = y;
                        continue;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new N3().minimumLines(new int[][]{{36,9},{17,93},{34,4},{30,11},{11,41},{53,36},{5,92},
                {81,92},{28,36},{3,45},{72,33},{64,1},{4,70},{16,73},{99,20},{49,33},{47,74},{83,91}});
    }
}
