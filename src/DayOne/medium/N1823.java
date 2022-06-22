package DayOne.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author hdq
 * @create 2022-05-04 11:43
 */
public class N1823 {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            for (int i = 0; i <k-1 ; i++) {
                queue.add(queue.remove());
            }
            queue.remove();
        }

        return queue.remove();
    }

    public static void main(String[] args) {
        N1823 n1823 = new N1823();
        System.out.println(n1823.findTheWinner(5,2));
    }
}
