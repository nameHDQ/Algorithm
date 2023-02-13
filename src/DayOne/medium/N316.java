package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class N316 {
    public String removeDuplicateLetters(String s) {
        int[] nums = new int[26];
        boolean[] vis = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']){
                while (sb.length() > 0 && sb.charAt(sb.length() - 1)  > ch){
                    if (nums[sb.charAt(sb.length() - 1) - 'a'] > 0){
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }else {
                        break;
                    }
                }
                sb.append(ch);
                vis[ch - 'a'] = true;
            }
            nums[ch - 'a'] -=1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new N316().removeDuplicateLetters("abacb"));
    }
}
