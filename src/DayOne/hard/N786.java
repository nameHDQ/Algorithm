package DayOne.hard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author hdq
 * @create 2021-11-29 9:37
 */
public class N786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
                    if ((o1[0]*1.0)/o1[1]-(o2[0]*1.0)/o2[1] > 0){
                        return 1;
                    }else {
                        return -1;
                    }
        });
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <i ; j++) {
                int[] temp = new int[2];
                temp[0] = arr[j];
                temp[1] = arr[i];
                heap.add(temp);
            }
        }
        for (int i = 1; i < k; i++) {
            heap.poll();
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        N786 n786 = new N786();
        int[] arr = {1,2,3,5};
        int[] ints = n786.kthSmallestPrimeFraction(arr, 3);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
