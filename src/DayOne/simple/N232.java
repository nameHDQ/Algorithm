package DayOne.simple;

import java.util.Stack;

public class N232 {


    class MyQueue {
        private int size;
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            this.size = 0;
            this.inStack = new Stack();
            this.outStack = new Stack();
        }

        public void push(int x) {
            inStack.push(x);


        }

        public int pop() {
            if (outStack.isEmpty()){
                while (!inStack.isEmpty()){
                    outStack.add(inStack.pop());
                }
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()){
                while (!inStack.isEmpty()){
                    outStack.add(inStack.pop());
                }
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }
}
