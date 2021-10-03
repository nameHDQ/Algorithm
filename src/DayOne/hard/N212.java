package DayOne.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-09-16 10:55
 */
public class N212 {
    List<String> list = new LinkedList<>();
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length,n = board[0].length;
        int[][] state = new int[m][n];

        for (int i = 0; i < words.length; i++) {
            int[][] statep = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (statep[j][k] == 0){
                        state[j][k] =1;
                        dp(statep,state,board,words[i],0,j,k);
                        state[j][k] =0;
                    }
                }

            }

        }
        return list;
    }
    public void dp(int[][] statep,int[][] state ,char[][] board,String words ,int index,int i,int j){

        if (words.charAt(index) == board[i][j]){
            if (index == words.length()-1){
                list.add(words);
                for (int k = 0; k < state.length; k++) {
                    for (int l = 0; l < state[0].length; l++) {
                        statep[k][l] +=state[k][l];
                    }
                }
                return;
            }
            int[] x = {1,-1,0,0};
            int[] y = {0,0,1,-1};
            for (int k = 0; k < 4; k++) {
                int newI = i +x[k];
                int newJ = j +y[k];
                if (newI<0||newJ<0||newI>=board.length||newJ>=board[0].length||state[newI][newJ] == 1||statep[newI][newJ] == 1){
                    continue;
                }
                state[newI][newJ] = 1;
                dp(statep,state,board,words,index+1,newI,newJ);
                state[newI][newJ] = 0;
            }
        }else {
            return;
        }
    }

    public static void main(String[] args) {
        N212 n212 = new N212();
        char[][] board = {{'a','b','c','e'},{'x','x','c','d'},{'x','x','b','a'}};
        String[] words = {"abc","abcd"};
        List<String> words1 = n212.findWords(board, words);
        for (String str :
                words1) {
            System.out.println(str);
        }
    }
}
