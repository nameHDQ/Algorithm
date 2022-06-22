package DayOne.simple;

import java.util.Stack;

/**
 * @author hdq
 * @create 2022-03-26 13:22
 */
public class N682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {

            if (op.equals("C")) {
                stack.pop();
            }else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            }else if (op.equals("+")) {
                stack.push(stack.peek() + stack.get(stack.size() - 2));
            }else {
                stack.push(Integer.valueOf(op));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
