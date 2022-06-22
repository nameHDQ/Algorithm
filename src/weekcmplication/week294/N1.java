package weekcmplication.week294;

/**
 * @author hdq
 * @create 2022-05-22 10:14
 */
public class N1 {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }
        return count * 100 / s.length();
    }
}
