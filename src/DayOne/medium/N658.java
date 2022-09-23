package DayOne.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class N658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = k - 1;
        for (int i = 0; i < k; i++) {
            deque.add(Math.abs(arr[i] - x));
            result.add(arr[i]);
        }

        int temp = 0;
        for (int i = k; i < arr.length; i++) {
            temp = Math.abs(arr[i] - x);
            if (temp < deque.getFirst()){
                deque.removeFirst();
                deque.add(temp);
                result.remove(0);
                result.add(arr[i]);
            }
        }
        return result;
    }
}
