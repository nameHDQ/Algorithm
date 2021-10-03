package DP;

import java.util.List;

/**
 * @author hdq
 * @create 2021-08-30 16:18
 */
public class N120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int[][] dp= new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        int len = 10001;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                    if(j != 0  && j != triangle.get(i).size()-1){
                        dp[i][j] = Math.min(dp[i-1][j-1]+triangle.get(i).get(j),dp[i-1][j]+triangle.get(i).get(j));
                    }else if (j == 0){
                        dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                    }else  if (j == triangle.get(i).size()-1){
                        dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                    }
            }
        }
        for (int i = 0; i < triangle.size(); i++) {
            if (dp[triangle.size()-1][i] < len){
                len = dp[triangle.size()-1][i];
            }
        }
        return len;
    }

    public static void main(String[] args) {

    }
}
