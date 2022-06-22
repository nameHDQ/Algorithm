package DayOne.simple;

/**
 * @author hdq
 * @create 2022-04-26 9:01
 */
public class N883 {
    public int projectionArea(int[][] grid) {
        int countXY = 0;
        int countXZ = 0;
        int countYZ = 0;
        for (int i = 0; i < grid.length; i++) {
            int tempYZ = 0;
            int tempXZ = 0;
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    countXY++;
                }
                tempYZ = Math.max(grid[i][j], tempYZ);
                tempXZ = Math.max(grid[j][i], tempXZ);
            }
            countYZ += tempYZ;
            countXZ += tempXZ;
        }
        return countXY + countXZ + countYZ;
    }
}
