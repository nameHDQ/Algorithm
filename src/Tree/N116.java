package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hdq
 * @create 2021-08-26 12:19
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class N116 {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (i <size-1){
                    poll.next = queue.peek();
                }
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }
}
