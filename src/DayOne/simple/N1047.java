package DayOne.simple;

import java.util.ArrayDeque;
import java.util.Deque;

public class N1047 {
    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        deque.push(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (deque.peek() == null || chars[i] != deque.peek()){
                deque.push(chars[i]);
            }else {
                deque.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (deque.size() > 0){
            sb.append(deque.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        new N1047().removeDuplicates("abbaca");
    }
}
