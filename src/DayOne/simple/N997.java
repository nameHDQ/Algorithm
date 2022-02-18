package DayOne.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author hdq
 * @create 2021-12-19 13:34
 */
public class N997 {
    public int findJudge(int n, int[][] trust) {
        int[] inEdge = new int[n];
        int[] outEdge = new int[n];
        for (int i = 0; i < trust.length; i++) {
            inEdge[trust[i][1]]++;
            outEdge[trust[i][0]]++;
        }
        for (int i = 0; i < n; i++) {
            if (outEdge[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
