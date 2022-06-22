package DayOne.simple;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-06-13 10:37
 */
public class N1051 {

    int[] expected;
    public int heightChecker(int[] heights) {
        int n = heights.length;
        this.expected = new int[n];
        this.expected = heights.clone();
        Arrays.sort(expected);
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (expected[i] != heights[i]){
                result++;
            }
        }
        return result;
    }
}
