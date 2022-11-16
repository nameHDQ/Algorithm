package DayOne.medium;

import java.util.Stack;

public class N739 {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()){
                stack.push(i);
                continue;
            }
            // 栈中的温度比当前的低的出栈
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                Integer idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        if (!stack.isEmpty()){
            for (Integer integer : stack) {
                res[integer] = 0;
            }
        }
        return res;
    }
}
