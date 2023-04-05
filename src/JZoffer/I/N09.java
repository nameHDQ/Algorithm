package JZoffer.I;

import java.util.ArrayDeque;
import java.util.Deque;

public class N09 {
    class CQueue {

        Deque<Integer> deque1;
        Deque<Integer> deque2;

        public CQueue() {
            deque1 = new ArrayDeque<>();
            deque2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            deque1.push(value);
        }

        public int deleteHead() {
            if (!deque2.isEmpty()){
                return deque2.pop();
            }
            while (!deque1.isEmpty()){
                deque2.push(deque1.pop());
            }
            return deque2.isEmpty() ? -1 : deque2.pop();
        }
    }
}
