package DayOne.medium;

import java.util.HashMap;
import java.util.Map;

public class N1769 {
    public int[] minOperations(String boxes) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = boxes.length();

        int[] ans = new int[len];
        char[] chars = boxes.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < len; j++) {
                if (j != i && chars[j] == '1'){
                    tempSum+= Math.abs(i - j);
                }
            }
            ans[i] = tempSum;
        }
        return ans;
    }

    public static void main(String[] args) {
        new N1769().minOperations1("110");
    }
    public int[] minOperations1(String boxes) {
        int left = boxes.charAt(0) - '0', right = 0, operations = 0;
        int n = boxes.length();
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                operations += i;
            }
        }
        int[] res = new int[n];
        res[0] = operations;
        for (int i = 1; i < n; i++) {
            operations += left - right;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
            res[i] = operations;
        }
        return res;
    }

}
