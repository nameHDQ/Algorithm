package DayOne.medium;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author hdq
 * @create 2021-12-18 16:48
 */
public class N139 {
    int[] memo;
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
    public boolean wordBreak1(String s, List<String> wordDict) {

        memo = new int[s.length()];

        Arrays.fill(memo, -1);
        boolean res = backTrack(s, wordDict, 0);
        return res;
    }
    public boolean wordBreak2(String s, List<String> wordDict) {

        int len = s.length();

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                if (set.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                }
            }

        }
        
        return dp[len];
    }


    boolean backTrack(String s, List<String> wordDict, int index){

        if (s.length() == index){
            return true;
        }
        if (memo[index] != -1){
            return memo[index] == 1;
        }
        memo[index] = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            if (index + wordDict.get(i).length() <= s.length()){

                if (startWith(s, index, wordDict.get(i))) {
                    boolean res = backTrack(s, wordDict, index + wordDict.get(i).length());
                    if (res) {
                        memo[index] = 1;
                    }
                }
            }
        }
        return memo[index] == 1;
    }

    boolean startWith(String s, int startIndex, String str){
        for (int i = 0; i < str.length(); i++) {
            if (s.charAt(startIndex + i) != str.charAt(i)){
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
