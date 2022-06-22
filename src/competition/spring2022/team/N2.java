package competition.spring2022.team;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-04-23 15:19
 */
public class N2 {
    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        int n = matrix.length;
        int m = matrix[0].length();
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        int count = 0;
        dfs(matrix, start[0], start[1], end, visited);
        while (!visited[end[0]][end[1]]) {
            ArrayList<int[]> edges = getEdges(matrix, visited);
            for (int[] edge : edges) {
                dfs(matrix, edge[0], edge[1], end, visited);
            }
            count++;
        }
        return count;
    }

    private ArrayList<int[]> getEdges(String[] matrix, boolean[][] visited) {
        ArrayList<int[]> edges = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length(); j++) {
                if (!visited[i][j]) {
                    if ((i - 1 >= 0 && !visited[i - 1][j])|| (i + 1 < matrix.length && !visited[i + 1][j]) || (j - 1 >= 0 && !visited[i][j - 1]) || (j + 1 < matrix[0].length() && !visited[i][j + 1])) {
                        edges.add(new int[]{i, j});
                    }
                }
            }
        }
        return edges;
    }

    private void dfs(String[] matrix, int i, int j, int[] end, boolean[][] visited) {
        // 到达终点
        if (i == end[0] && j == end[1]) {
            return;
        }
        // 根据当前位置，找到可以走的位置
        String line = matrix[i];
        char op = line.charAt(j);
        // 可以走的位置
        if (op == '^') {
            // 没有环，能接着走
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                dfs(matrix, i - 1, j, end, visited);
                return;
            }
        }else if (op == '>') {
            if (j + 1 < line.length() && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                dfs(matrix, i, j + 1, end, visited);
                return;
            }
        }else if (op == 'v') {
            if (i + 1 < matrix.length && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                dfs(matrix, i + 1, j, end, visited);
                return;
            }

        }else if (op == '<') {
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                dfs(matrix, i, j - 1, end, visited);
                return;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new N2().conveyorBelt(new String[]{">>v", "v^<", "<><"}, new int[]{0, 1}, new int[]{2, 0}));
    }
}
