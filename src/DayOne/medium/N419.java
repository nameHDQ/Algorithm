package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-18 15:51
 */
public class N419 {
    public int countBattleships(char[][] board) {
        int ans = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((board[i][j] == 'X')&&(i==0||board[i-1][j] !='X')&&(j==0||board[i][j-1] != 'X')){
                    ans++;
                }
            }
        }

        return ans;
    }
}
