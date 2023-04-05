package DayOne.medium;

public class N1824 {
    public int minSideJumps(int[] obstacles) {
        int len = obstacles.length;
        int[][] dp = new int[len + 1][3];
        dp[0][0] = 1;
        dp[0][2] = 1;
        for (int i = 1; i < obstacles.length; i++) {
            if (obstacles[i] - 1 != 0){
                dp[i][0] = dp[i  - 1 ][0];
            }else {
                dp[i][0] = Integer.MAX_VALUE - 3 ;
            }
            if (obstacles[i] - 1 != 1){
                dp[i][1] = dp[i  - 1 ][1];
            }else {
                dp[i][1] = Integer.MAX_VALUE - 3;
            }
            if (obstacles[i] - 1 != 2){
                dp[i][2] = dp[i  - 1 ][2];
            }else {
                dp[i][2] = Integer.MAX_VALUE - 3;
            }

            if (obstacles[i] - 1 != 0){
                dp[i][0] = Math.min(dp[i][0], Math.min(dp[i][1],dp[i][2]) + 1);
            }
            if (obstacles[i] - 1 != 1){
                dp[i][1] = Math.min(dp[i][1], Math.min(dp[i][0],dp[i][2]) + 1);
            }
            if (obstacles[i] - 1 != 2){
                dp[i][2] = Math.min(dp[i][2], Math.min(dp[i][1],dp[i][0]) + 1);
            }
        }
        return Math.min(dp[len - 1][2],Math.min(dp[len - 1][1], dp[len - 1][0]));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,0};
        System.out.println(new N1824().minSideJumps(nums));
    }
}
