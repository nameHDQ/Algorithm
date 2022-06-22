package DayOne.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-04-08 11:28
 */
public class N429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Node> curLevel = new ArrayList<>();
        curLevel.add(root);
        while (!curLevel.isEmpty()) {
            int size = curLevel.size();
            List<Integer> level = new ArrayList<>();
            List<Node> nextLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = curLevel.get(i);
                // 当前层的节点添加到结果中
                level.add(node.val);
                int len = node.children.size();
                // 下一层的节点
                for (int j = 0; j < len; j++) {
                    nextLevel.add(node.children.get(j));
                }
            }
            res.add(level);
            curLevel = nextLevel;
        }
        return res;
    }
}
