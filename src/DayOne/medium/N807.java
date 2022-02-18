package DayOne.medium;

import java.net.Inet4Address;
import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-12-13 9:58
 */
public class N807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] lineMax = new int[grid.length];
        int[] rowMax = new int[grid[0].length];
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            lineMax[i] = Arrays.stream(grid[i]).max().getAsInt();
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[j][i] > rowMax[i]){
                    rowMax[i] = grid[j][i];
                }
            }
        }
        for (int i = 0; i <grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total+=Math.min(lineMax[i],rowMax[j])-grid[i][j];
            }
        }
        return total;
    }
}
