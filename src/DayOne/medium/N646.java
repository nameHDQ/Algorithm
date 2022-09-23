package DayOne.medium;

import java.util.Arrays;

public class N646 {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b)->{
            return a[1] - b[1];
        });

        int result = 1;
        int temp = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][1] > temp){
                result++;
                temp = pairs[i][1];
            }

        }
        return result;
    }
}
