package niuniu.mediumClass;

import java.util.Scanner;

public class N6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        int[] dp = new int[chars.length];
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')'){
                int pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '('){
                    dp[i] = dp[i - 1] + 2+ (pre > 0 ? dp[pre - 1] : 0);
                }
                res = Math.max(dp[i], res);
            }
        }
        System.out.println(res);
    }
    //)()(())((()()
}
