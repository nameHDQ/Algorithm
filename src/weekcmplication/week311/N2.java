package weekcmplication.week311;

import javafx.scene.control.SpinnerValueFactory;

public class N2 {
    public int longestContinuousSubstring(String s) {

        if (s.length() == 1) return 1;
        char[] chars = s.toCharArray();
        int pre = 0;
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1] + 1){
                res = Math.max(res, i - pre + 1);
                continue;
            }else {
                res = Math.max(res, i - pre);
                pre = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N2().longestContinuousSubstring("a"));
    }
}
