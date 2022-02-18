package DayOne.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-12-08 12:49
 */
public class N438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> re = new ArrayList<>();

        if (s.length()<p.length()){
            return re;
        }

        int k = p.length();
        int[] map = new int[26];
        for (int i = 0; i < k; i++) {
            map[p.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {

            map[s.charAt(i)-'a']--;
            if (i>=k-1){
                boolean ok = true;
                for (int j = 0; j < 26; j++) {
                    if (map[j] !=0 ){
                        ok = false;
                    }
                }
                if (ok){
                    re.add(i-k+1);
                }
                map[s.charAt(i-k+1)-'a']++;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        N438 n438 = new N438();
        String s = "cbaebabacd";
        String p = "abc";
        for (Integer anagram : n438.findAnagrams(s, p)) {
            System.out.println(anagram);
        }
    }
}
