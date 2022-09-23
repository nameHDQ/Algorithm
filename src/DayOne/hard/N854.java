package DayOne.hard;

import javafx.util.Pair;

import java.util.*;

public class N854 {
    public int kSimilarity(String s1, String s2) {


        Deque<Pair<String, Integer>> deque = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        set.add(s1);
        deque.offer(new Pair<>(s1, 0));
        int count = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Pair<String, Integer> pair = deque.poll();
                String key = pair.getKey();
                Integer value = pair.getValue();
                // result
                if (key.equals(s2)){
                    return count;
                }
                // 后面相同  不用比较了
                while (value < key.length() && key.charAt(value) == s2.charAt(value)){
                    value++;
                }

                for (int j = value + 1; j < key.length(); j++) {

                    // 若当前位子两个串相等，这没必要换，不然加大次数了
                    if (s2.charAt(j) == key.charAt(j)) {
                        continue;
                    }


                    // s2中多个与当前位置字符相等的， 都交换，便利所有可能性
                    if (s2.charAt(value) == key.charAt(j)){
                        String swap = swap(key, value, j);
                        if (!set.contains(swap)){
                            set.add(swap);
                            deque.offer(new Pair<>(swap, value+1));
                        }
                    }
                }
            }
            count++;

        }
        return count;
    }

    public String swap(String cur, int i, int j) {
        char[] arr = cur.toCharArray();
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        return new String(arr);
    }
}
