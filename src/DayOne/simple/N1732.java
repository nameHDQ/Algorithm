package DayOne.simple;

/**
 * @author hdq
 * @create 2022-03-10 16:56
 */
public class N1732 {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
