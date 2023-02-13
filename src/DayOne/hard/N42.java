package DayOne.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class N42 {
    public int trap(int[] height) {
        Deque<Integer> deque = new ArrayDeque<>();

        int ans = 0;
        for (int i = 0; i < height.length; i++) {

            while (!deque.isEmpty() && height[i] > height[deque.peek()]){
                Integer rightMin = deque.pop();
                if (deque.isEmpty()){
                    break;
                }

                int leftHigh = deque.peek();
                int width = i- leftHigh - 1;
                int H = Math.min(height[i] , height[leftHigh]) - height[rightMin];
                ans += width * H;

            }
            deque.push(i);
        }

        return ans;
    }
}
