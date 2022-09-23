package DayOne.simple;

import java.util.Arrays;

public class N1619 {
    public double trimMean(int[] arr) {

        double ans = 0;

        Arrays.sort(arr);
        for (int i = arr.length / 20; i < arr.length * 19 / 20; i++) {
            ans += arr[i];
        }
        return ans / (arr.length * 9/10);
    }
}
