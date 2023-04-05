package DayOne.simple;



import java.util.ArrayDeque;
import java.util.Queue;

public class N225 {
    class MyStack {

        private Queue<Integer> inQueue;
        private Queue<Integer> outQueue;

        public MyStack() {
            inQueue = new ArrayDeque<>();
            outQueue = new ArrayDeque<>();

        }

        public void push(int x) {
            inQueue.add(x);

        }

        public int pop() {
            int reslt = 0;
            if (!inQueue.isEmpty()){
                while (inQueue.size() != 1){
                    outQueue.add(inQueue.poll());
                }
                reslt = inQueue.poll();
            }else {
                while (outQueue.size() != 1){
                    inQueue.add(outQueue.poll());
                }
                reslt = outQueue.poll();
            }
            return reslt;
        }

        public int top() {
            int reslt = 0;
            if (!inQueue.isEmpty()){
                while (!inQueue.isEmpty()){
                    reslt = inQueue.poll();
                    outQueue.add(reslt);
                }
            }else {
                while (!outQueue.isEmpty()){
                    reslt = outQueue.poll();
                    inQueue.add(reslt);
                }
            }
            return reslt;
        }

        public boolean empty() {
            return inQueue.isEmpty() && outQueue.isEmpty();
        }
    }
}
