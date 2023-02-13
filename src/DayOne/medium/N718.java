package DayOne.medium;

public class N718 {
    public int findLength(int[] nums1, int[] nums2) {

        int res = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]){
                dp[i][0] = 1;
                res = 1;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == nums1[0]){
                dp[0][i] = 1;
                res = 1;
            }
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
        new N718().findLength(nums,nums2);
    }
}
