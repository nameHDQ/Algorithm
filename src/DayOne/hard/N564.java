package DayOne.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-03-02 12:35
 */
public class N564 {
    public String nearestPalindromic(String n) {
        long selfNumber = Long.parseLong(n), ans = -1;
        List<Long> candidates = getCandidates(n);
        for (long candidate : candidates) {
            if (candidate != selfNumber) {
                if (ans == -1 ||
                        Math.abs(candidate - selfNumber) < Math.abs(ans - selfNumber) ||
                        Math.abs(candidate - selfNumber) == Math.abs(ans - selfNumber) && candidate < ans) {
                    ans = candidate;
                }
            }
        }
        return Long.toString(ans);
    }
    public List<Long> getCandidates(String n) {
        int len = n.length();
        List<Long> candidates = new ArrayList<>(){
            {
                add((long) Math.pow(10, len - 1) - 1);
                add((long) Math.pow(10, len) +1);
            }
        };
        Long selfPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = selfPrefix - 1; i <= selfPrefix + 1; i++) {
            StringBuffer sb = new StringBuffer();
            String prefix = String.valueOf(i);
            sb.append(prefix);
            StringBuffer suffix = new StringBuffer(prefix).reverse();
            sb.append(suffix.substring(len & 1));
            candidates.add(Long.parseLong(sb.toString()));

        }
        return candidates;
    }

    public static void main(String[] args) {
        System.out.println(new N564().nearestPalindromic("12513"));
    }
}
