package DayOne;

import java.awt.geom.FlatteningPathIterator;

/**
 * @author hdq
 * @create 2021-08-24 11:12
 */
public class N3 {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        if (s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        for (int i = 0,j = i+1; j< s.length() ; ) {
            boolean falg = false;
            for (int k = i;k<j;k++){
                if (s.charAt(k) ==s.charAt(j)){
                    length = Math.max(length,j-i);
                    i = k+1;
                    j++;
                    falg = true;
                    break;
                }
            }
            if (!falg){
                length = Math.max(j-i+1,length);
                j++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        N3 n3 = new N3();
        System.out.println(n3.lengthOfLongestSubstring("pwwkew"));
    }
}
