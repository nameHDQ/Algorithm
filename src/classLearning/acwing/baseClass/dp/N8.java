package classLearning.acwing.baseClass.dp;

import java.util.Scanner;

public class N8 {
    public static void main(String[] args) {

        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        new N8().trap(nums);
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String[] strNums = in.nextLine().split(" ");
        int m = Integer.parseInt(strNums[0]);
        int n = Integer.parseInt(strNums[1]);
        String s = in.nextLine();
        String t = in.nextLine();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char s1 = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char t1 = t.charAt(j - 1);
                // 相等，直接加
                if (s1 == t1){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    // 不想等，有两个都不选，选左，选右，三个考虑的分之
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i ][j - 1]);
                }
            }
        }
        System.out.println(dp[m][n]);
    }

    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
