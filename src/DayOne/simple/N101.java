package DayOne.simple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hdq
 * @create 2022-02-25 10:53
 */
public class N101 {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()){

            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            // 这里顺序与使用Deque不同
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }

    public boolean compare(TreeNode left, TreeNode right){
        if (left == null && right != null) return false;
        else if (right == null && left != null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;
        boolean is_left = compare(left.left, right.right);
        boolean is_right = compare(left.right, right.left);
        return  is_left && is_right;
    }
}
