package weekcmplication.week294;

/**
 * @author hdq
 * @create 2022-05-22 11:27
 */
public class N4 {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        long[] preSum = new long[n + 1];
        long[] LasSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] += preSum[i] + strength[i];
        }
        for (int i = n; i > 0 ; i--) {
            LasSum[i - 1] += LasSum[i] + strength[i - 1];
        }
        long ans = 0;


        return 0;
    }
}
