package DayOne.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-12-07 12:28
 */
public class N986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        if (firstList.length == 0 || secondList.length == 0){
            return res.toArray(new int[res.size()][]);
        }
        for (int i = 0; i < firstList.length; i++) {
            for (int j = 0; j < secondList.length; j++) {

                int lo = Math.max(firstList[i][0],secondList[j][0]);
                int ro = Math.min(firstList[i][1],secondList[j][1]);
                if (lo <= ro){
                    int[] temp = {lo,ro};
                    res.add(temp);
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        N986 n986 = new N986();
        int[][] first = {{1,3},{5,9}};
        int[][] second = {};
        for (int[] ints : n986.intervalIntersection(first, second)) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }
}
