package DayOne.medium;

import java.util.List;
import java.util.Stack;

/**
 * @author hdq
 * @create 2021-12-14 12:13
 */
public class N79 {
    boolean res = false;
    int[] index_X = {0,1,0,-1};
    int[] index_Y ={1,0,-1,0};
    public boolean exist(char[][] board, String word) {
        boolean[][] isUse = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    isUse[i][j] = true;
                    dfs(isUse, board, word, i,j, 1);
                    isUse[i][j] = false;
                }
            }
        }
        return res;
    }
    public void dfs(boolean[][] isUse,char[][] board, String word,int i,int j ,int idx){
        if (idx > word.length()){
            res = true;
            return;
        }
        for (int k = 0; k < 4 ; k++) {
            int newX = i + index_X[k];
            int newY = j +index_Y[k];
            if (newX <0 || newX>=board.length ||newY<0
                    ||newY >=board[0].length ||isUse[newX][newY]){
                continue;
            }
            if (board[newX][newY] == word.charAt(idx)){
                isUse[newX][newY] = true;
                dfs(isUse, board, word, newX, newY, idx+1);
                isUse[newX][newY] = false;
            }
        }
    }

    public static void main(String[] args) {

    }
}
