package weekcmplication.week323;

import java.util.Arrays;

public class N1 {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int tempMax = 0;
            for (int j = 0; j < m; j++) {
                tempMax = Math.max(tempMax, grid[j][i]);
            }
            res += tempMax;

        }
        return res;
    }
}
