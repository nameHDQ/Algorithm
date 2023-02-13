package DayOne.hard;

/**
 * @author hdq
 * @create 2021-12-21 19:41
 */
public class N72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // 0-i 0-j操作的最小次数
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化 0 i 删除i个  I 次
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    // 添加等价于删除另一个字符 ， 删除有删除两个字符串区别，替换等价于 前一对相等的+1;
                    // shan
                    dp[i][j] = Math.min(dp[ i - 1][j],dp[i][j - 1] );
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    dp[i][j] += 1; //当前操作次数+1
                }
            }
        }
        return dp[len1][len2];
    }
}
