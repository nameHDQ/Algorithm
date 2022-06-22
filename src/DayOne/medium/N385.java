package DayOne.medium;


import java.util.Stack;

class NestedInteger {
    public NestedInteger() {
    }

    public NestedInteger(int value) {

    }
    public void add(NestedInteger ni){

    }
}
/**
 * @author hdq
 * @create 2022-04-15 12:11
 */
public class N385 {
    public NestedInteger deserialize(String s) {
        // 非列表，单个数字
        if(s.charAt(0) != '['){
            return new NestedInteger(Integer.parseInt(s));
        }


        Stack<NestedInteger> stack = new Stack<>();
        boolean negative = false;
        int nums = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '-'){
                negative = true;
            }else if(Character.isDigit(c)){
                nums = nums * 10 + (c - '0');
            }else if(c == '['){
                stack.push(new NestedInteger());
            }else if(c == ',' || c == ']'){
                if(Character.isDigit(s.charAt(i-1))){
                    if(negative){
                        nums = -nums;
                    }
                    stack.peek().add(new NestedInteger(nums));
                }
                negative = false;
                nums = 0;
                if (c == ']' && stack.size() > 1) {
                    NestedInteger top = stack.pop();
                    stack.peek().add(top);
                }
            }
        }
        return stack.pop();
    }
}
