package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class N946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i : pushed) {
            deque.push(i);
            while (!deque.isEmpty() && deque.peek() == popped[index]){
                index++;
                deque.pop();
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        new N946().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1});
    }
}
