package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class N769 {
    public int maxChunksToSorted(int[] arr) {

        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : arr) {
            if (deque.isEmpty() || num > deque.peek()){
                deque.push(num);
            }else {

                Integer pop = deque.pop();
                while (!deque.isEmpty() && deque.peek() > num){
                    deque.pop();
                }
                deque.push(pop);
            }
        }
        return deque.size();
    }
}
