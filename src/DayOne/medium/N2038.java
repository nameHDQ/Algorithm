package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-22 10:32
 */
public class N2038 {
    public boolean winnerOfGame(String colors) {
        if (colors.length() < 3) {
            return false;
        }
        int count = 0;
        for (int i = 1; i < colors.length()-1; i++) {
            if (colors.charAt(i - 1)  == 'A' && colors.charAt(i) == 'A' && colors.charAt(i+1) == 'A') {
                count++;
            }
            if (colors.charAt(i - 1)  == 'B' && colors.charAt(i) == 'B' && colors.charAt(i+1) == 'B') {
                count--;
            }
        }
        return count == 0;
    }
}
