package DayOne.medium;

import java.util.HashMap;
import java.util.Map;

public class N48 {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 1;
        if (s.length() == 1) return maxLen;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                maxLen = Math.max(i - start, maxLen);

                int end = map.get(chars[i]);
                while (start<= end){
                    map.remove(chars[start]);
                    start++;
                }
                map.put(chars[i], i);

            } else {
                map.put(chars[i], i);
            }
        }
        return Math.max(maxLen,map.size());
    }
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        int top = 0;
        int bottom = matrix.length - 1;
        while (top < bottom){
            for (int i = 0; i < n; i++) {
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = temp;
            }
            top++;
            bottom--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        }

        return;
    }

    public static void main(String[] args) {
        new N48().lengthOfLongestSubstring("abcabcbb");
    }
}
