package DayOne.medium;


import DayOne.DataStruct.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hdq
 * @create 2021-12-10 10:28
 */
public class N117 {
    Queue<Node> queue = new LinkedList<>();
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        queue.add(root);
        while (queue.size() > 0){
            int n = queue.size();
            Node pre = null;
            for (int i = 0; i < n; i++) {
                Node cur = queue.poll();
                if (cur.left !=null){
                    queue.offer(cur.left);
                }
                if (cur.right !=null){
                    queue.offer(cur.right);
                }
                if (i != 0){
                    pre.next = cur;
                }
                pre = cur;
            }
        }
        return root;
    }
}
