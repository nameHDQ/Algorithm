package DayOne.simple;

import java.util.Map;

/**
 * @author hdq
 * @create 2022-04-12 10:06
 */
public class N806 {
    public int[] numberOfLines(int[] widths, String s) {

        int[] result = new int[2];
        int line = 1;
        int width = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int temp = width + widths[index];
            if (temp > 100) {
                line++;
                width = widths[index];
            }else {
                width = temp;
            }
        }
        result[0] = line;
        result[1] = width;
        return result;
    }
}
