package DayOne.hard;


import java.util.*;

public class N895 {
    class FreqStack {
        Map<Integer, Integer> mapCount;
        Map<Integer, List<Integer>> mapStack;
        int maxCount;
        public FreqStack() {
            mapCount = new HashMap<>();
            mapStack = new HashMap<>();
            maxCount = 0;
        }

        public void push(int val) {
            mapCount.put(val, mapCount.getOrDefault(val, 0) + 1);
            int c = mapCount.get(val);
            List<Integer> list = mapStack.getOrDefault(c, new ArrayList<>());
            list.add(val);
            mapStack.put(c, list);
            maxCount = Math.max(maxCount, c);
        }
        public int pop() {
            List<Integer> list = mapStack.get(maxCount);
            int ans = list.remove(list.size() - 1);
            mapCount.put(ans, mapCount.get(ans) - 1);
            if (list.size() == 0) maxCount--;
            return ans;
        }
    }

    public static void main(String[] args) {
        FreqStack freqStack = new N895().new FreqStack();
        freqStack.push (5);//堆栈为 [5]
        freqStack.push (7);//堆栈是 [5,7]
        freqStack.push (5);//堆栈是 [5,7,5]
        freqStack.push (7);//堆栈是 [5,7,5,7]
        freqStack.push (4);//堆栈是 [5,7,5,7,4]
        freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
        freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
        freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
        freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
        freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
    }
}
