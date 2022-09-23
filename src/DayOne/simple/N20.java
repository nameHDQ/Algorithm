package DayOne.simple;

import java.util.Stack;

public class N20 {
    public boolean isValid(String s) {
        if (s.length() == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.add(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char temp = stack.pop();
                    if ((s.charAt(i) == ']' && temp == '[') ||
                            (s.charAt(i) == '}' && temp == '{') ||
                            (s.charAt(i) == ')' && temp == '(')) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }

        }
        return stack.isEmpty();
    }
}
