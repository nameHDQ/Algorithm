package DayOne.medium;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-03-31 13:57
 */
public class N424 {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int max = 0;
        int start = 0;
        int len = 0;
        for (int end = 0; end < s.length(); end++) {
            max = Math.max(max, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - max > k) {
                count[s.charAt(start) - 'A']--;
                max = Arrays.stream(count).max().getAsInt();
                start++;
            }
            len = Math.max(len, end - start + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        N424 n424 = new N424();
        System.out.println(n424.characterReplacement("AABABBA", 1));
    }
}
