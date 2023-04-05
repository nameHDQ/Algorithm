package CodeTop;

public class N5 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int len = s.length();
        int start = 0;
        int strLen = 1;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)){
                    continue;
                }
                if (i + 1 == j || i + 2 == j){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > strLen){
                    strLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + strLen);
    }

    public String longestPalindrome1(String s) {

        int len = s.length();
        int start = 0;
        int strLen = 0;
        for (int i = 0; i < len; i++) {
            if (len - i <= strLen / 2){
                break;
            }
            int left = i, right = i;
            while (right + 1 < len && s.charAt(right) == s.charAt(right + 1)){
                right++;
            }
            while (right + 1 < len && left - 1 >= 0 &&  s.charAt(left - 1) == s.charAt(right + 1)){
                left--;
                right++;
            }

            if (right - left + 1 > strLen){
                strLen = right - left + 1;
                start = left;
            }
        }
        return s.substring(start, start + strLen);
    }

    public static void main(String[] args) {
        System.out.println(new N5().longestPalindrome1("babad"));
    }
}
