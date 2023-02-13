package DayOne.medium;

import DayOne.DataStruct.Node;

/**
 * @author hdq
 * @create 2021-12-17 11:16
 */
public class N5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (s.length() < 2){
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxLen = 1;
        //字串的长度从2开始判断，逐渐增加，判断是否有该长度的字串
        for (int i = 2; i < len; i++) {
            //每次判断都从0开始搜索
            for (int left = 0; left < len; left++) {
                int right = i + left - 1;
                if (right >= len) {
                    break;
                }
                if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                } else {
                    if (right - left < 3) {
                        //<3判断 是2个字符 还是中间间隔一个的三个字符
                        dp[left][right] = true;
                    } else {
                        //大于等于三 那么之前有子串为true直接赋值即可
                        dp[left][right] = dp[left + 1][right - 1];

                    }
                }
                if (dp[left][right] && right -left +1> maxLen){
                    maxLen = right - left+1;
                    start = left;
                }
            }
        }
        return s.substring(start, start+maxLen);
    }

    public String longestPalindrome1(String s) {
        int len = s.length();
        if (s.length() == 1) return s;
        boolean[][] dp = new boolean[len + 1][len + 1];
        int length = 1;
        int start = 0;
        for (int j = 1; j <= len; j++) {
            for (int i = 1; i <= j; i++) {
                if (s.charAt(i-1) == s.charAt(j - 1)){
                    if (j - i <=2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 > length){
                    start = i - 1;
                    length = Math.max(length, j - i + 1);
                }
            }
        }
        return s.substring(start, start + length);
    }

    public static void main(String[] args) {
        N5 n5 = new N5();
        System.out.println(n5.longestPalindrome1("babad"));
    }
}
