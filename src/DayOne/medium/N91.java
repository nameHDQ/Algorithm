package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-18 15:59
 */
public class N91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[s.length()];
        if (s.length()<2){
            return 1;
        }
        dp[0] = 1;
        if (s.charAt(1) == '0'){
            dp[1] = 1;
        }else {
            if (Integer.valueOf(s.substring(0, 2)) <=26){
                dp[1] = 2;
            }else {
                dp[1] = 1;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0'){
                if (s.charAt(i-1) > '2'){
                    return 0;
                }else {
                    if (s.charAt(i-1) == '0'){
                        return 0;
                    }
                    dp[i] = dp[i-2];
                }
            }else {
                if (Integer.valueOf(s.substring(i-1, i+1)) <=26){
                    if (s.charAt(i-1) == '0'){
                        dp[i] = dp[i-1];
                    }else {
                        dp[i] = dp[i-1] + dp[i-2];
                    }

                }else {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        N91 n91 = new N91();
        System.out.println(n91.numDecodings("221001"));
    }
}
