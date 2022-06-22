package DayOne.medium;

/**
 * @author hdq
 * @create 2022-02-24 11:47
 */
public class N1706 {
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i, res, grid[0][i], i);
        }
        return res;
    }
    public void dfs(int[][] grid, int i, int j, int[] res, int pre, int index) {
        int m = grid[0].length;
        int n = grid.length;
            // 平行向右
            if (pre == 1) {
                if (j + 1 < m && grid[i][j + 1] == 1) {
                    if (i + 1 < n ) {
                        dfs(grid, i + 1, j + 1, res, grid[i + 1][j + 1], index);
                    }else {
                        res[index] = j + 1;
                    }

                }else {
                    res[index] = -1;
                }
            }else {
                if (j - 1 >= 0 && grid[i][j - 1] == -1) {
                    // 未到底
                    if (i + 1 < n) {
                        dfs(grid, i + 1, j - 1, res, grid[i + 1][j - 1], index);
                    }else {
                        //到底了
                        res[index] = j - 1;
                    }

                }else {
                    res[index] = -1;
                }
        }
    }

    public static void main(String[] args) {
        N1706 n1706 = new N1706();
        int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        for (int i : n1706.findBall(grid)) {
            System.out.println(i);
        }
    }
}
