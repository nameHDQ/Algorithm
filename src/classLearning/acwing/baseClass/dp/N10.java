package classLearning.acwing.baseClass.dp;

import java.util.Scanner;

public class N10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String[] nums = in.nextLine().split(" ");
        int m = Integer.parseInt(nums[0]);
        int n = Integer.parseInt(nums[1]);
        String[] findStr = new String[m];
        for (int i = 0; i < m; i++) {
            findStr[i] = in.nextLine();
        }
        while (n-- >= 0){
            String[] strs = in.nextLine().split(" ");
            String temp = strs[0];
            int limit = Integer.parseInt(strs[1]);
            int res = 0;
            for (int i = 0; i < m; i++) {
                int len = findStr[i].length();
                int[][] dp = new int[temp.length() + 1][len + 1];
                for (int j = 0; j <= temp.length(); ++j) {
                    dp[j][0] = j;
                }
                for (int k = 0; k <= len; ++k) {
                    dp[0][k] = k;
                }
                for (int j = 1; j <= temp.length(); j++) {
                    char s1 = temp.charAt(j - 1);
                    for (int k = 1; k <= len; k++) {
                        char t1 = findStr[i].charAt(k - 1);
                        if (s1 == t1){
                            dp[j][k] = dp[j - 1][k - 1];
                        }else {
                            //考虑删除，添加，添加A相当于删除B
                            dp[j][k] = Math.min(dp[j - 1][k], dp[j][k - 1]) + 1;
                            // 替换，
                            dp[j][k] = Math.min(dp[j][k], dp[j - 1][k - 1] + 1);
                        }
                    }
                }
                if (dp[temp.length()][findStr[i].length()] <= limit){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
