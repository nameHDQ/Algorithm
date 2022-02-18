package DayOne.hard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hdq
 * @create 2021-12-23 13:07
 */
public class N1044 {
    long[] h,p;
    public String longestDupSubstring(String s) {
        int pow = 1313131, n = s.length();
        h = new long[n+10];p=new long[n+10];
        p[0] = 1;
        for (int i = 0; i < n; i++) {
            p[i+1] = p[i]*pow;
            h[i+1] = h[i]*pow+s.charAt(i);
        }
        String ans = "";
        int l = 0, r = n;
        while (l < r){
            int mid = l+r+1 >>1;
            String t = check(s, mid);
            if (t.length() != 0) l =mid;
            else r= mid-1;
            ans = t.length() > ans.length() ? t:ans;
        }
        return ans;
    }
    public String check(String s ,int len){
        int n = s.length();
        Set<Long> strCode = new HashSet<>();
        for (int i = 1; i+len - 1 <= n ; i++) {
            int j = i+len - 1;
            long cur = h[j] - h[i-1]*p[j-i+1];
            if (strCode.contains(cur)){
                return s.substring(i-1, j);
            }
            strCode.add(cur);
        }
        return "";
    }
}
