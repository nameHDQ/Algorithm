package weekcmplication.week297;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-06-12 10:05
 */
public class N2 {

    private int minValue = Integer.MAX_VALUE;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 下面是上一行所有点到 下一行j处的路径最小
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.min(dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j], dp[i][j]);
                }
            }
        }

        m--;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[m][i]);
        }


//        for (int i = 0; i < n; i++) {
//            dfs(grid, moveCost, 0, grid[0][i], grid[0][i], 0);
//        }
        return ans;
    }

    public void dfs(int[][] grid, int[][] moveCost, int idx,int curNode, int nodeValue, int allCost){
        int tempValue = allCost + nodeValue;
        if (tempValue > minValue){
            return;
        }
        if (idx == grid.length - 1){
            if (tempValue < minValue){
                minValue = tempValue;
                return;
            }
            return;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int temp = nodeValue + grid[idx + 1][i] + allCost + moveCost[curNode][i];
            if (temp < minValue){
                dfs(grid, moveCost, idx + 1, grid[idx + 1][i],nodeValue + grid[idx + 1][i], allCost + moveCost[curNode][i]);
            }

        }
    }

    public static void main(String[] args) {
        int[][] grid = {{5,3},{4,0},{2,1}};
        int[][] moveCost = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};

        System.out.println(new N2().minPathCost(grid, moveCost));
    }
}
