package weekcmplication.doubleweek78;

/**
 * @author hdq
 * @create 2022-05-14 22:27
 */
public class N1 {
    public int divisorSubstrings(int num, int k) {

        String s = String.valueOf(num);
        int count = 0;
        int len = s.length();
        if (len < k) {
            return 0;
        }
        for (int i = 0; i <= len - k; i++) {
            String substring = s.substring(i, i + k);
            int temp = Integer.valueOf(substring);
            if (temp != 0 && num % temp == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new N1().divisorSubstrings(430043, 2));
    }
}
