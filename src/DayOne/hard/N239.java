package DayOne.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class N239 {
    public int[] maxSlidingWindow(int[] nums, int k) {


        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {

            // 新窗口 单调队列里的节点是否还在这个窗口
            while (!deque.isEmpty() && deque.peekLast() < i - k + 1) {
                deque.poll();
            }

            // 新窗口 往队列里加元素，是否比队列里的大
            // 比尾元素大 一直出对到比尾元素小
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);

            if (i - k + 1 >= 0) {
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
