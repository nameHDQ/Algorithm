package DayOne.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class N32 {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        Deque<Integer> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int maxLen = 0;
        deque.push(-1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                deque.push(i);
            }else {
                deque.pop();
                if (deque.isEmpty()){
                    deque.push(i);
                }else {
                    maxLen = Math.max(maxLen, i - deque.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        new N32().longestValidParentheses("()");
    }
}
