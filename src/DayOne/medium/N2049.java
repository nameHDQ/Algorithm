package DayOne.medium;

import DayOne.DataStruct.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-03-11 20:25
 */
public class N2049 {
    long maxScore = 0;
    int cnt = 0;
    List<Integer>[] children ;
    int n;
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            int parent = parents[i];
            if (parent != -1) {
                children[parent].add(i);
            }
        }
        dfs(0);
        return cnt;
    }

    private int dfs(int removeNode) {
         // n-1个节点 不包含去除的当前节点
        int size = n-1;
        long score = 1;

        for (int child : children[removeNode]) {
            int nodeSum = dfs(child);
            score *= nodeSum;
            size -= nodeSum;
        }
        // 不是根节点 要加上根节点形成的子树
        if (removeNode != 0) {
            score *= size;
        }
        if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }else if (score == maxScore) {
            cnt++;
        }
        // 当前节点的子节点数目
        return n-size;
    }

    public static void main(String[] args) {
        System.out.println(new N2049().countHighestScoreNodes(new int[]{-1,2,0}));
    }
}
