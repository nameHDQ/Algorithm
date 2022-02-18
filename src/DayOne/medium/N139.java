package DayOne.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-12-18 16:48
 */
public class N139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int minLen = Integer.MAX_VALUE;
        while (s.length()>0){
            for (String s1 : wordDict) {
                int len = s1.length();
                if (len < minLen){
                    minLen = len;
                }
                if (len > s.length()) continue;
                String str = s.substring(0,len);
                if (s1.equals(str)){
                    s = s.substring(len, s.length());
                }
            }
            if (s.length() < minLen && s.length() > 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        N139 n139 = new N139();
        List<String> str = new LinkedList<>();
        str.add("apple");
        str.add("pen");
        System.out.println(n139.wordBreak("applepenapple",str));
    }
}
