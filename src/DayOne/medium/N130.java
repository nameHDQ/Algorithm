package DayOne.medium;

import javax.swing.border.Border;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hdq
 * @create 2021-12-11 13:18
 */
public class N130 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public void solve(char[][] board) {
        if (board.length == 1){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue =new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O'){
                board[i][0] = 'A';
                queue.offer(new int[]{i,0});
            }
            if (board[i][n-1] == 'O'){
                board[i][n-1] = 'A';
                queue.offer(new int[]{i,n-1});
            }
        }
        for (int i = 1; i < n-1; i++) {
            if (board[0][i] == 'O'){
                board[0][i] = 'A';
                queue.offer(new int[]{0,i});
            }
            if (board[n-1][i] == 'O'){
                board[n-1][i] = 'A';
                queue.offer(new int[]{n-1,i});
            }
        }
        boolean[][] badNode = new boolean[board.length][board.length];
        while (queue.size() > 0){
            int[] cur = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int[] newInx = {cur[0] + dx[i],cur[1] + dy[i]};
                if (newInx[0] < 0 || newInx[0] >= m || newInx[1] <0 ||newInx[1] >= n
                        || board[newInx[0]][newInx[1]] != 'O'){
                    continue;
                }
                queue.add(newInx);
                board[newInx[0]][newInx[1]] = 'A';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
        N130 n130 = new N130();
    }
}
