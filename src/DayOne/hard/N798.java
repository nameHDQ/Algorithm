package DayOne.hard;

/**
 * @author hdq
 * @create 2022-03-09 12:35
 */
public class N798 {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] numsK = new int[n];
        int maxScore = 0;
        int res = 0;
        for (int k = 0; k < n; k++) {
            int score = 0;
            for (int j = 0; j < n; j++) {
                int index = (j - k + n) % n;
                if (nums[j] <= index) {
                    score++;
                }
            }
            if (score > maxScore) {
                maxScore = score;
                res = k;
            }
        }
        return maxScore;
    }

}
