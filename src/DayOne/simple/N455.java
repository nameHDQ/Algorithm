package DayOne.simple;

import java.util.Arrays;
import java.util.Comparator;

public class N455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int g_start = g.length - 1;
        int s_start = s.length - 1;
        int res = 0;
        while (g_start >= 0 && s_start >= 0){

            if (s[s_start] >= g[g_start]){
                res++;
                g_start--;
                s_start--;
            }else {
                g_start--;
            }
        }
        return res;
    }
}
