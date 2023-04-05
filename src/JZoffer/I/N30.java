package JZoffer.I;

import java.util.ArrayDeque;
import java.util.Deque;

public class N30 {
    class MinStack {
        Deque<Integer>  deque ;
        int min = Integer.MAX_VALUE;
        Deque<Integer> minDeque = new ArrayDeque<>();
        /** initialize your data structure here. */
        public MinStack() {
            deque = new ArrayDeque<>();
            minDeque.push(min);
        }

        public void push(int x) {
            deque.push(x);
            min = Math.min(min, x);
            minDeque.push(min);
        }

        public void pop() {
            deque.pop();
            minDeque.pop();
            min = minDeque.peek();
        }

        public int top() {
            return deque.peek();
        }

        public int min() {
            return minDeque.peek();
        }
    }
}
