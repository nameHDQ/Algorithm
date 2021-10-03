package DayOne;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author hdq
 * @create 2021-08-24 11:44
 */
public class N567 {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        if (n1>n2){
            return false;
        }
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < n1; i++) {
            c1[s1.charAt(i) -'a']++;
            c2[s2.charAt(i) -'a']++;
        }
        if (Arrays.equals(c1,c2)){
            return true;
        }
        for (int i = n1; i < n2; i++) {
            c2[s2.charAt(i) - 'a']++;
            c2[s2.charAt(i-n1) -'a']--;
            if (Arrays.equals(c1,c2)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        N567 n567 = new N567();
        System.out.println(n567.checkInclusion("ab", "eidboaoo"));
    }
}
