package DayOne.simple;

import java.util.Stack;

/**
 * @author hdq
 * @create 2022-05-28 10:10
 */
public class N1021 {
    public String removeOuterParentheses(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()){
                sb.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return sb.toString();
    }
}
